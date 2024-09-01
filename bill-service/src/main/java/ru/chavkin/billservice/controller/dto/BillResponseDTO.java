package ru.chavkin.billservice.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.chavkin.billservice.entity.Bill;
import ru.chavkin.billservice.entity.enumeration.BillEnum;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

/**
 * @author vladimirchavkinwork@gmail.com
 */

@AllArgsConstructor
@Getter
public class BillResponseDTO {

    private Long id;

    private BigDecimal amount;

    private Boolean isActive;

    private Boolean isConfirmed;

    private BillEnum currency;

    private OffsetDateTime createdOn;

    private OffsetDateTime updatedOn;

    private Long accountId;

    public BillResponseDTO(Bill bill) {
        id = bill.getId();
        amount = bill.getAmount();
        isActive = bill.getIsActive();
        isConfirmed = bill.getIsConfirmed();
        currency = bill.getCurrency();
        createdOn = bill.getCreatedOn();
        updatedOn = bill.getUpdatedOn();
        accountId = bill.getAccountId();
    }


}
