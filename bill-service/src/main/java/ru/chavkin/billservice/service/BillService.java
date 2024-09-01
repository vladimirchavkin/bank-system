package ru.chavkin.billservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.chavkin.billservice.entity.Bill;
import ru.chavkin.billservice.entity.enumeration.BillEnum;
import ru.chavkin.billservice.exception.BillException;
import ru.chavkin.billservice.repository.BillRepository;

import java.math.BigDecimal;

/**
 * @author vladimirchavkinwork@gmail.com
 */


@Service
@Slf4j
public class BillService {

    private final BillRepository billRepository;


    @Autowired
    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    /**
     * Create account
     * @param amount Amount
     * @param isActive Is bill active
     * @param isConfirmed Is bill Confirmed
     * @param currency Currency
     * @param accountId Account id
     * @return createdBill Created bill
     */
    public Bill createBill(BigDecimal amount, Boolean isActive, Boolean isConfirmed, BillEnum currency, Long accountId) {
        log.info("REST request to create bill with: amount={}, isActive={}, isConfirmed={}, currency={}, accountId={}",
                amount, isActive, isConfirmed, currency, accountId);
        Bill createdbill = new Bill(amount, isActive, isConfirmed, currency, accountId);
        log.debug("Created bill={}", createdbill);
        return billRepository.save(createdbill);
    }

    /**
     * Get bill by id
     * @param id Bill id
     * @return Bill by id
     */
    public Bill getBillById(Long id) {
        log.info("REST request to get bill by id={}", id);
        return billRepository.findById(id).orElseThrow(() ->
                new BillException("Bill with id = " + id + " is not exist"));
    }

    /**
     * Get all bills
     * @return All bills
     */
    public Iterable<Bill> getAllBills() {
        log.info("REST request to get all bills");
        return billRepository.findAll();
    }

    /**
     * Update bill
     * @param id Id
     * @param amount Amount
     * @param isActive Is bill active
     * @param isConfirmed Is bill confirmed
     * @param currency Currency
     * @param accountId Account id
     * @return Updated bill
     */
    public Bill updateBill(Long id, BigDecimal amount, Boolean isActive, Boolean isConfirmed, BillEnum currency,
                           Long accountId) {
        log.info("REST request to update bill(id={}) with: amount={}, isActive={}, isConfirmed={}, currency={}, accountId={}",
                id, amount, isActive, isConfirmed, currency, accountId);
        Bill updatedBill = getBillById(id);
        updatedBill.setAmount(amount);
        updatedBill.setIsActive(isActive);
        updatedBill.setIsConfirmed(isConfirmed);
        updatedBill.setCurrency(currency);
        updatedBill.setAccountId(accountId);

        log.debug("Updated Bill={}", updatedBill);
        return billRepository.save(updatedBill);
    }

    /**
     * Delete bill by id
     * @param id Bill id
     * @return Deleted bill
     */
    public Bill deleteBill(Long id) {
        log.info("REST request to delete bill with id={}", id);
        Bill deletedBill = getBillById(id);

        log.debug("Deleted bill={}", deletedBill);
        billRepository.deleteById(id);

        return deletedBill;
    }
}
