package ru.chavkin.depositservice.rest.bill;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author vladimirchavkinwork@gmail.com
 */

@FeignClient(value = "bill-service", url = "http://localhost:8765")
public interface BillServiceClient {

    @RequestMapping(value = "/api/v1/bills/{billId}", method = RequestMethod.GET)
    BillResponseDTO getBillById(@PathVariable("billId") Long billId);

    @RequestMapping(value = "/api/v1/bills/{billId}", method = RequestMethod.PUT)
    BillResponseDTO updateBill(@PathVariable("billId") Long billId, BillRequestDTO billRequestDTO);
}
