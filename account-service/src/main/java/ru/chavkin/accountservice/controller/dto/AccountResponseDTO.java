package ru.chavkin.accountservice.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.chavkin.accountservice.entity.Account;

import java.time.OffsetDateTime;

/**
 * @author vladimirchavkinwork@gmail.com
 */

@AllArgsConstructor
@Getter
public class AccountResponseDTO {

    private Long id;

    private String name;

    private String surname;

    private String email;

    private String phoneNumber;

    private OffsetDateTime createdOn;

    private OffsetDateTime updatedOn;

    private Long billId;

    public AccountResponseDTO(Account account) {
        id = account.getId();
        name = account.getName();
        surname = account.getSurname();
        email = account.getEmail();
        phoneNumber = account.getPhoneNumber();
        createdOn = account.getCreatedOn();
        updatedOn = account.getUpdatedOn();
        billId = account.getBillId();
    }
}
