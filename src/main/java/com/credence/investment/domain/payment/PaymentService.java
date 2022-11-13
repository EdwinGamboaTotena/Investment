package com.credence.investment.domain.payment;

import com.credence.investment.domain.common.dto.PaginatorDto;
import com.credence.investment.domain.common.exception.BadRequest;
import com.credence.investment.domain.investment.Investment;
import com.credence.investment.domain.investment.ports.IInvestmentRepository;
import com.credence.investment.domain.investment.ports.IInvestmentService;
import com.credence.investment.domain.payment.dto.CreatePaymentDto;
import com.credence.investment.domain.payment.dto.UpdatePaymentDto;
import com.credence.investment.domain.payment.port.IPaymentRepository;
import com.credence.investment.domain.payment.port.IPaymentService;
import com.credence.investment.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Transactional
public class PaymentService implements IPaymentService {

    public static final String PAYMENT_NOT_FOUND = "No se encontro el pago a actualizar";

    @Autowired
    private IPaymentRepository repository;

    @Autowired
    private IInvestmentRepository investmentRepository;

    @Override
    public PaginatorDto<Payment> get(String investmentId, int page, int size) {
        Page<Payment> payments = repository.get(UUID.fromString(investmentId), page, size);
        PaginatorDto<Payment> paginator = new PaginatorDto<>();

        paginator.setTotalPages(payments.getTotalPages());
        paginator.setTotalElements(payments.getTotalElements());
        paginator.setContent(payments.getContent());
        return paginator;
    }

    @Override
    public Payment getById(String id) {
        return repository.getById(UUID.fromString(id));
    }

    @Override
    public Payment create(String investmentId, CreatePaymentDto dto, String user) {
        Investment investment = investmentRepository.getById(UUID.fromString(investmentId));
        if (investment == null) {
            throw new BadRequest("No se a encontrado la inversion");
        }

        Payment payment = new Payment();
        payment.setAmount(dto.getAmount());
        payment.setCurrency(dto.getCurrency());
        payment.setAddedToCapital(investment.isCompoundInterest());
        payment.setNote(dto.getNote());
        payment.setStatus(PaymentStatusEnum.TO_PAY);
        payment.setCreateBy(User.builder().id(user).build());
        payment.setCreateAt(LocalDateTime.now());
        payment.setUpdateAt(LocalDateTime.now());

        payment.isValid();
        investment.addPayment(payment);
        return investmentRepository.save(investment)
                .getPayments().stream()
                .filter(p -> p.getCreateAt().equals(payment.getCreateAt()))
                .findFirst().orElse(null);
    }

    @Override
    public void update(String id, UpdatePaymentDto dto, String user) {
        Payment payment = repository.getById(UUID.fromString(id));
        if (payment == null) {
            throw new BadRequest(PAYMENT_NOT_FOUND);
        }
        payment.setAmount(dto.getAmount());
        payment.setCurrency(dto.getCurrency());
        payment.setAddedToCapital(dto.isAddedToCapital());
        payment.setNote(dto.getNote());
        payment.setStatus(dto.getStatus());
        payment.setCreateBy(User.builder().id(user).build());
        payment.setUpdateAt(LocalDateTime.now());

        payment.isValid();
        repository.update(payment);
    }
}
