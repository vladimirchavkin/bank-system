package ru.chavkin.accountservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.chavkin.accountservice.entity.Account;

/**
 * @author vladimirchavkinwork@gmail.com
 */

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
}
