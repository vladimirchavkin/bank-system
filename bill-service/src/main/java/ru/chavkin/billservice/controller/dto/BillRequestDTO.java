package ru.chavkin.billservice.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.chavkin.billservice.entity.enumeration.BillEnum;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

/**
 * @author vladimirchavkinwork@gmail.com
 */

@NoArgsConstructor
@Getter
@Schema(description = "Bill DTO")
public class BillRequestDTO {

    @Schema(description = "Bill amount")
    private BigDecimal amount;

    @Schema(description = "Bill isActive status")
    private Boolean isActive;

    @Schema(description = "Bill isConfirmed status")
    private Boolean isConfirmed;

    @Schema(description = "Bill currency")
    private BillEnum currency;

    @Schema(description = "Bill createdOn timestamp")
    private OffsetDateTime createdOn;

    @Schema(description = "Bill updatedOn timestamp")
    private OffsetDateTime updatedOn;

    @Schema(description = "Bill account id")
    private Long accountId;

}
