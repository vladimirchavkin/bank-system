package ru.chavkin.accountservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.chavkin.accountservice.entity.Account;
import ru.chavkin.accountservice.exception.AccountException;
import ru.chavkin.accountservice.repository.AccountRepository;

import java.time.OffsetDateTime;

/**
 * @author vladimirchavkinwork@gmail.com
 */

@Service
@Slf4j
public class AccountService {

    private final AccountRepository accountRepository;


    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /**
     * Create Account
     *
     * @param name        Name
     * @param surname     Surname
     * @param email       Email
     * @param phoneNumber Phone number
     * @param billId      Bill Id
     * @return createdAccount Created Account
     */
    public Account createAccount(String name, String surname, String email, String phoneNumber, Long billId) {
        log.info("REST request to create account with: name={}, surname={}, email={}, phoneNumber={}, billId={}",
                name, surname, email, phoneNumber, billId);
        Account createdAccount = new Account(name, surname, email, phoneNumber, billId);
        log.debug("Created account: {}", createdAccount);
        return accountRepository.save(createdAccount);
    }

    /**
     * Get Account by id
     *
     * @param id Account id
     * @return Account The account found by id
     */
    public Account getAccountById(Long id) {
        log.info("REST request to get account by id with id={}", id);
        return accountRepository.findById(id).orElseThrow(() ->
                new AccountException("Account with id = " + id + "is not exist"));
    }

    /**
     * Get all Accounts
     *
     * @return All Accounts
     */
    public Iterable<Account> getAllAccounts() {
        log.info("REST request to get all accounts");
        return accountRepository.findAll();
    }

    /**
     * Update Account
     *
     * @param id          Id
     * @param name        Name
     * @param surname     Surname
     * @param email       Email
     * @param phoneNumber Phone number
     * @param billId      Bill id
     * @return Updated Account
     */
    public Account updateAccount(Long id, String name, String surname, String email, String phoneNumber, Long billId) {
        log.info("REST request to update account(id={}) with: name={}, surname={}, email={}, phoneNumber={}, billId={} ",
                id, name, surname, email, phoneNumber, billId);
        Account updatedAccount = getAccountById(id);
        updatedAccount.setName(name);
        updatedAccount.setSurname(surname);
        updatedAccount.setEmail(email);
        updatedAccount.setPhoneNumber(phoneNumber);
        updatedAccount.setUpdatedOn(OffsetDateTime.now());

        log.debug("Updated account={}", updatedAccount);
        return accountRepository.save(updatedAccount);
    }

    /**
     * Delete Account by id
     * @param id Id
     * @return Deleted Account
     */
    public Account deleteAccount(Long id) {
        log.info("REST request to delete account with id={}", id);
        Account deletedAccount = getAccountById(id);

        log.debug("Deleted account = {}", deletedAccount);
        accountRepository.deleteById(id);

        return deletedAccount;
    }
}
