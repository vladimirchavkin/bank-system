package ru.chavkin.depositservice.entity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author vladimirchavkinwork@gmail.com
 */

@Getter
@NoArgsConstructor
public class DepositRequestDTO {

    private BigDecimal amount;

    private Long accountId;

    private Long billId;


}
