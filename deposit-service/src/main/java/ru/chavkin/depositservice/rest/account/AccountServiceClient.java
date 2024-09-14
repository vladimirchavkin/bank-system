package ru.chavkin.depositservice.rest.account;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author vladimirchavkinwork@gmail.com
 */

@FeignClient(value = "account-service", url = "http://localhost:8765")
public interface AccountServiceClient {

    @RequestMapping(value = "/api/v1/accounts/{accountId}", method = RequestMethod.GET)
    AccountResponseDTO getAccountById(@PathVariable("accountId") Long accountId);
}