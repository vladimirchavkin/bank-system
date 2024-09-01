package ru.chavkin.billservice.repository;

import org.springframework.data.repository.CrudRepository;
import ru.chavkin.billservice.entity.Bill;

/**
 * @author vladimirchavkinwork@gmail.com
 */

public interface BillRepository extends CrudRepository<Bill, Long> {
}
