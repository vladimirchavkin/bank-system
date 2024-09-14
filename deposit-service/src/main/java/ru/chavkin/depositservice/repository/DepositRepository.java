package ru.chavkin.depositservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.chavkin.depositservice.entity.Deposit;

/**
 * @author vladimirchavkinwork@gmail.com
 */

@Repository
public interface DepositRepository extends CrudRepository<Deposit, Long> {
}
