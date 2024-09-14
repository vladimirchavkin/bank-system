package ru.chavkin.depositservice.rest.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

/**
 * @author vladimirchavkinwork@gmail.com
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AccountResponseDTO {

    private Long accountId;

    private String name;

    private String surname;

    private String phoneNumber;

    private String email;

    private OffsetDateTime updatedOn;

    private Long billId;
}
