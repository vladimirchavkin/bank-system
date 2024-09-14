package ru.chavkin.depositservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.chavkin.depositservice.entity.dto.DepositRequestDTO;
import ru.chavkin.depositservice.entity.dto.DepositResponseDTO;
import ru.chavkin.depositservice.service.DepositService;

/**
 * @author vladimirchavkinwork@gmail.com
 */


@RestController
@RequestMapping("/api/v1/deposits")
public class DepositController {

    private final DepositService depositService;

    @Autowired
    public DepositController(DepositService depositService) {
        this.depositService = depositService;
    }

    @PostMapping("/")
    public DepositResponseDTO deposit(@RequestBody DepositRequestDTO depositRequestDTO) {
        return depositService.deposit(depositRequestDTO.getAccountId(), depositRequestDTO.getBillId(),
                depositRequestDTO.getAmount());
    }
}
