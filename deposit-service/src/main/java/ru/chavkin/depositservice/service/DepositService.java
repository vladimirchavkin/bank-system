package ru.chavkin.depositservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.chavkin.depositservice.entity.Deposit;
import ru.chavkin.depositservice.entity.dto.DepositResponseDTO;
import ru.chavkin.depositservice.exception.DepositException;
import ru.chavkin.depositservice.repository.DepositRepository;
import ru.chavkin.depositservice.rest.account.AccountResponseDTO;
import ru.chavkin.depositservice.rest.account.AccountServiceClient;
import ru.chavkin.depositservice.rest.bill.BillRequestDTO;
import ru.chavkin.depositservice.rest.bill.BillResponseDTO;
import ru.chavkin.depositservice.rest.bill.BillServiceClient;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

/**
 * @author vladimirchavkinwork@gmail.com
 */

@Service
public class DepositService {


    private final DepositRepository depositRepository;

    private final AccountServiceClient accountServiceClient;

    private final BillServiceClient billServiceClient;


    @Autowired
    public DepositService(DepositRepository depositRepository, AccountServiceClient accountServiceClient,
                          BillServiceClient billServiceClient) {
        this.depositRepository = depositRepository;
        this.accountServiceClient = accountServiceClient;
        this.billServiceClient = billServiceClient;
    }


    public DepositResponseDTO deposit(Long accountId, Long billId, BigDecimal amount) {
        if (accountId == null && billId == null) {
            throw new DepositException("Account is null and bill is null");
        }
        if (billId != null) {
            BillResponseDTO billResponseDTO = billServiceClient.getBillById(billId);
            BillRequestDTO billRequestDTO = createBillRequest(amount, billResponseDTO);

            billServiceClient.updateBill(billId, billRequestDTO);

            AccountResponseDTO accountResponseDTO = accountServiceClient.getAccountById(billRequestDTO.getAccountId());

            depositRepository.save(new Deposit(amount, billId, accountResponseDTO.getEmail()));

            return createDepositResponse(amount, accountResponseDTO);
        }

        BillResponseDTO billResponseDTO = getBillByAccountId(accountId);
        BillRequestDTO billRequestDTO = createBillRequest(amount, billResponseDTO);
        billServiceClient.updateBill(billResponseDTO.getBillId(), billRequestDTO);

        AccountResponseDTO accountResponseDTO = accountServiceClient.getAccountById(accountId);
        depositRepository.save(new Deposit(amount, billResponseDTO.getBillId(), accountResponseDTO.getEmail()));
        return createDepositResponse(amount, accountResponseDTO);
    }

    private BillResponseDTO getBillByAccountId(Long accountId) {
        try {
            return billServiceClient.getBillById(accountId);
        } catch (DepositException depositException) {
            throw new DepositException("Unable to find bill with accountId=" + accountId);
        }
    }


    private DepositResponseDTO createDepositResponse(BigDecimal amount, AccountResponseDTO accountResponseDTO) {
        DepositResponseDTO depositResponseDTO = new DepositResponseDTO(amount, accountResponseDTO.getEmail());

        /*
            TODO: sending message to Kafka
         */
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValueAsString(depositResponseDTO);
        } catch (JsonProcessingException e) {
            throw new DepositException("Error while sending message to Kafka");
        }
        return depositResponseDTO;
    }

    private static BillRequestDTO createBillRequest(BigDecimal amount, BillResponseDTO billResponseDTO) {
        BillRequestDTO billRequestDTO = new BillRequestDTO();
        billRequestDTO.setAccountId(billResponseDTO.getAccountId());
        billRequestDTO.setAmount(billResponseDTO.getAmount().add(amount));
        billRequestDTO.setIsActive(billResponseDTO.getIsActive());
        billRequestDTO.setIsConfirmed(billResponseDTO.getIsConfirmed());
        billRequestDTO.setCurrency(billResponseDTO.getCurrency());
        billRequestDTO.setCreatedOn(billResponseDTO.getCreatedOn());
        billRequestDTO.setUpdatedOn(OffsetDateTime.now());

        return billRequestDTO;
    }
}
