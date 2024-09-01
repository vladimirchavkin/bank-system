package ru.chavkin.accountservice.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

/**
 * @author vladimirchavkinwork@gmail.com
 */

@NoArgsConstructor
@Getter
@Schema(description = "Account DTO")
public class AccountRequestDTO {

    @Schema(description = "Account name")
    private String name;

    @Schema(description = "Account surname")
    private String surname;

    @Schema(description = "Account email")
    private String email;

    @Schema(description = "Account phone number")
    private String phoneNumber;

    @Schema(description = "Account creating timestamp")
    private OffsetDateTime createdOn;

    @Schema(description = "Account updating timestamp")
    private OffsetDateTime updatedOn;

    @Schema(description = "Account bill id")
    private Long billId;
}
