package com.credence.investment.application.payment;

import com.credence.investment.domain.common.dto.PaginatorDto;
import com.credence.investment.domain.payment.Payment;
import com.credence.investment.domain.payment.dto.CreatePaymentDto;
import com.credence.investment.domain.payment.dto.UpdatePaymentDto;
import com.credence.investment.domain.payment.port.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/investment/{investmentId}/payment")
public class PaymentController {

    @Autowired
    private IPaymentService service;

    @GetMapping
    PaginatorDto<Payment> getPayments(@PathVariable String investmentId, @RequestParam int page, @RequestParam int size) {
        return service.get(investmentId, page, size);
    }

    @GetMapping("/{id}")
    Payment getPaymentById(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping
    Payment createPayment(@PathVariable String investmentId, @RequestBody CreatePaymentDto dto, @RequestHeader String user) {
        return service.create(investmentId, dto, user);
    }

    @PutMapping("/{id}")
    void updatePayment(@PathVariable String id, @RequestBody UpdatePaymentDto dto, @RequestHeader String user) {
        service.update(id, dto, user);
    }
}
