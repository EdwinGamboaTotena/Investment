package com.credence.investment.domain.payment.port;

import com.credence.investment.domain.common.dto.PaginatorDto;
import com.credence.investment.domain.payment.Payment;
import com.credence.investment.domain.payment.dto.CreatePaymentDto;
import com.credence.investment.domain.payment.dto.UpdatePaymentDto;

public interface IPaymentService {

    PaginatorDto<Payment> get(String investmentId, int page, int size);

    Payment getById(String id);

    Payment create(String investmentId, CreatePaymentDto dto, String user);

    void update(String id, UpdatePaymentDto dto, String user);
}
