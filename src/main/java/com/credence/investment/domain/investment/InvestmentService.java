package com.credence.investment.domain.investment;

import com.credence.investment.domain.common.dto.PaginatorDto;
import com.credence.investment.domain.common.exception.BadRequest;
import com.credence.investment.domain.investment.dto.CreateInvestmentDto;
import com.credence.investment.domain.investment.dto.UpdateInvestmentDto;
import com.credence.investment.domain.investment.ports.IInvestmentRepository;
import com.credence.investment.domain.investment.ports.IInvestmentService;
import com.credence.investment.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Transactional
public class InvestmentService implements IInvestmentService {

    public static final String INVESTMENT_NOT_FOUND = "La inversion a actualizar no se encuentra";

    @Autowired
    private IInvestmentRepository repository;

    @Override
    public PaginatorDto<Investment> get(int page, int size) {
        Page<Investment> investments = repository.get(page, size);
        PaginatorDto<Investment> paginator = new PaginatorDto<>();

        paginator.setTotalPages(investments.getTotalPages());
        paginator.setTotalElements(investments.getTotalElements());
        paginator.setContent(investments.getContent());
        return paginator;
    }

    @Override
    public Investment getById(String id) {
        return repository.getById(UUID.fromString(id));
    }

    @Override
    public Investment create(CreateInvestmentDto createInvestmentDto, String userId) {
        Investment investment = new Investment();
        investment.setOwner(createInvestmentDto.getOwner());
        investment.setAmount(createInvestmentDto.getAmount());
        investment.setCurrency(createInvestmentDto.getCurrency());
        investment.setCreateAt(LocalDateTime.now());
        investment.setUpdateAt(LocalDateTime.now());
        investment.setPeriodInMonths(createInvestmentDto.getPeriodInMonths());
        investment.setPercentagePerMoth(createInvestmentDto.getPercentagePerMoth());
        investment.setCompoundInterest(createInvestmentDto.isCompoundInterest());
        investment.setNote(createInvestmentDto.getNote());
        investment.setCreateBy(User.builder().id(userId).build());
        investment.setActive(true);

        investment = repository.save(investment);
        return investment;
    }

    @Override
    public void update(String id, UpdateInvestmentDto updateInvestmentDto) {
        Investment investment = repository.getById(UUID.fromString(id));
        if (investment == null) {
            throw new BadRequest(INVESTMENT_NOT_FOUND);
        }
        investment.setOwner(updateInvestmentDto.getOwner());
        investment.setAmount(updateInvestmentDto.getAmount());
        investment.setCurrency(updateInvestmentDto.getCurrency());
        investment.setUpdateAt(LocalDateTime.now());
        investment.setPeriodInMonths(updateInvestmentDto.getPeriodInMonths());
        investment.setPercentagePerMoth(updateInvestmentDto.getPercentagePerMoth());
        investment.setCompoundInterest(updateInvestmentDto.isCompoundInterest());
        investment.setActive(updateInvestmentDto.isActive());
        investment.setNote(updateInvestmentDto.getNote());

        repository.save(investment);
    }

    @Override
    public void changeStatus(String id, boolean status) {
        Investment investment = repository.getById(UUID.fromString(id));
        if (investment == null) {
            throw new BadRequest(INVESTMENT_NOT_FOUND);
        }
        repository.changeStatus(UUID.fromString(id), status);
    }
}
