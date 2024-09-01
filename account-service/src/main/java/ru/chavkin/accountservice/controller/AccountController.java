package ru.chavkin.accountservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.chavkin.accountservice.controller.dto.AccountRequestDTO;
import ru.chavkin.accountservice.controller.dto.AccountResponseDTO;
import ru.chavkin.accountservice.exception.AccountException;
import ru.chavkin.accountservice.service.AccountService;

/**
 * @author vladimirchavkinwork@gmail.com
 */

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * Create account.
     *
     * @param accountRequestDTO for creating account.
     * @return Created account response.
     */
    @Operation(
            summary = "Create account",
            description = "Endpoint to create account"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(
                            description = "The object was successfully created",
                            contentMediaType = "application/json"
                    ))
            }),
            @ApiResponse(responseCode = "400", content = {
                    @Content(schema = @Schema(
                            description = "Error sending the request.",
                            implementation = AccountException.class,
                            contentMediaType = "application/json"
                    ))
            }),
            @ApiResponse(responseCode = "404", content = {
                    @Content(schema = @Schema(
                            description = "The entity was not found.",
                            implementation = AccountException.class,
                            contentMediaType = "application/json"
                    ))
            }),
            @ApiResponse(responseCode = "500", content = {
                    @Content(schema = @Schema(
                            description = "Internal server error.",
                            implementation = AccountException.class,
                            contentMediaType = "application/json"
                    ))
            })
    })
    @PostMapping("/")
    public AccountResponseDTO createAccount(@RequestBody AccountRequestDTO accountRequestDTO) {
        return new AccountResponseDTO(accountService.createAccount(accountRequestDTO.getName(), accountRequestDTO.getSurname(),
                accountRequestDTO.getEmail(), accountRequestDTO.getPhoneNumber(), accountRequestDTO.getBillId()));
    }

    /**
     * Get account by id.
     *
     * @param accountId Account id.
     * @return Account by accountId. If an account does not exist, throws AccountException
     */
    @Operation(
            summary = "Get account by id.",
            description = "Endpoint to get account by id"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(
                            description = "The object was successfully received",
                            contentMediaType = "application/json"
                    ))
            }),
            @ApiResponse(responseCode = "400", content = {
                    @Content(schema = @Schema(
                            description = "Error sending the request.",
                            implementation = AccountException.class,
                            contentMediaType = "application/json"
                    ))
            }),
            @ApiResponse(responseCode = "404", content = {
                    @Content(schema = @Schema(
                            description = "The entity was not found.",
                            implementation = AccountException.class,
                            contentMediaType = "application/json"
                    ))
            }),
            @ApiResponse(responseCode = "500", content = {
                    @Content(schema = @Schema(
                            description = "Internal server error.",
                            implementation = AccountException.class,
                            contentMediaType = "application/json"
                    ))
            })
    })
    @GetMapping("/{accountId}")
    public AccountResponseDTO getAccountById(@PathVariable Long accountId) {
        return new AccountResponseDTO(accountService.getAccountById(accountId));
    }

    /**
     * Update account.
     *
     * @param accountId Account id
     * @param accountRequestDTO DTO for update account.
     * @return Updated account response.
     */
    @Operation(
            summary = "Update account",
            description = "Endpoint to update account"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(
                            description = "The object was successfully updated",
                            contentMediaType = "application/json"
                    ))
            }),
            @ApiResponse(responseCode = "400", content = {
                    @Content(schema = @Schema(
                            description = "Error sending the request.",
                            implementation = AccountException.class,
                            contentMediaType = "application/json"
                    ))
            }),
            @ApiResponse(responseCode = "404", content = {
                    @Content(schema = @Schema(
                            description = "The entity was not found.",
                            implementation = AccountException.class,
                            contentMediaType = "application/json"
                    ))
            }),
            @ApiResponse(responseCode = "500", content = {
                    @Content(schema = @Schema(
                            description = "Internal server error.",
                            implementation = AccountException.class,
                            contentMediaType = "application/json"
                    ))
            })
    })
    @PutMapping("/{accountId}")
    public AccountResponseDTO updateAccount(@PathVariable Long accountId,
                                            @RequestBody AccountRequestDTO accountRequestDTO) {
        return new AccountResponseDTO(accountService.updateAccount(accountId, accountRequestDTO.getName(),
                accountRequestDTO.getSurname(), accountRequestDTO.getEmail(), accountRequestDTO.getPhoneNumber(),
                accountRequestDTO.getBillId()));
    }

    /**
     * Delete account by accountId.
     *
     * @param accountId for deleting account.
     * @return Deleted account by accountId.
     */
    @Operation(
            summary = "Delete account",
            description = "Endpoint to delete account"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(
                            description = "The object was successfully deleted",
                            contentMediaType = "application/json"
                    ))
            }),
            @ApiResponse(responseCode = "400", content = {
                    @Content(schema = @Schema(
                            description = "Error sending the request.",
                            implementation = AccountException.class,
                            contentMediaType = "application/json"
                    ))
            }),
            @ApiResponse(responseCode = "404", content = {
                    @Content(schema = @Schema(
                            description = "The entity was not found.",
                            implementation = AccountException.class,
                            contentMediaType = "application/json"
                    ))
            }),
            @ApiResponse(responseCode = "500", content = {
                    @Content(schema = @Schema(
                            description = "Internal server error.",
                            implementation = AccountException.class,
                            contentMediaType = "application/json"
                    ))
            })
    })
    @DeleteMapping("/{accountId}")
    public AccountResponseDTO deleteAccount(@PathVariable Long accountId) {
        return new AccountResponseDTO(accountService.deleteAccount(accountId));
    }

}
