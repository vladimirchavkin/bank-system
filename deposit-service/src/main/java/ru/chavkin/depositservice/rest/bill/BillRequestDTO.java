package ru.chavkin.depositservice.rest.bill;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.chavkin.depositservice.rest.bill.enumeration.BillEnum;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

/**
 * @author vladimirchavkinwork@gmail.com
 */

@NoArgsConstructor
@Getter
@Setter
public class BillRequestDTO {

    private Long accountId;

    private BigDecimal amount;

    private Boolean isActive;

    private Boolean isConfirmed;

    private BillEnum currency;

    private OffsetDateTime createdOn;

    private OffsetDateTime updatedOn;
}