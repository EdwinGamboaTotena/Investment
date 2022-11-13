package com.credence.investment.domain.payment.port;

import com.credence.investment.domain.payment.Payment;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface IPaymentRepository {

    Page<Payment> get(UUID investmentId, int page, int size);

    Payment getById(UUID id);

    Payment save(Payment model);
}
