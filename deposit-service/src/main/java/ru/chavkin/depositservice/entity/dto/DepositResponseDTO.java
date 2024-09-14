package ru.chavkin.depositservice.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author vladimirchavkinwork@gmail.com
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DepositResponseDTO {

    private BigDecimal amount;

    private String email;
}
