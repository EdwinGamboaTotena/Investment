package com.credence.investment.domain.investment;

import com.credence.investment.domain.common.dto.PaginatorDto;
import com.credence.investment.domain.common.enums.StatusEnum;
import com.credence.investment.domain.common.exception.BadRequest;
import com.credence.investment.domain.investment.dto.CreateInvestmentDto;
import com.credence.investment.domain.investment.dto.UpdateInvestmentDto;
import com.credence.investment.domain.investment.ports.IInvestmentRepository;
import com.credence.investment.domain.investment.ports.IInvestmentService;
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
    private IInvestmentRepository investmentRepository;

    @Override
    public PaginatorDto<Investment> getInvestmentsList(int page, int size) {
        Page<Investment> investments = investmentRepository.getInvestmentsList(page, size);
        PaginatorDto<Investment> paginator = new PaginatorDto<>();

        paginator.setTotalPages(investments.getTotalPages());
        paginator.setTotalElements(investments.getTotalElements());
        paginator.setContent(investments.getContent());
        return paginator;
    }

    @Override
    public Investment getInvestmentById(String id) {
        return investmentRepository.getInvestmentsById(UUID.fromString(id));
    }

    @Override
    public Investment createInvestment(CreateInvestmentDto createInvestmentDto) {
        Investment investment = new Investment();
        investment.setOwner(createInvestmentDto.getOwner());
        investment.setAmount(createInvestmentDto.getAmount());
        investment.setCurrency(createInvestmentDto.getCurrency());
        investment.setCreateDate(LocalDateTime.now());
        investment.setUpdateDate(LocalDateTime.now());
        investment.setPeriodInMonths(createInvestmentDto.getPeriodInMonths());
        investment.setPercentagePerMoth(createInvestmentDto.getPercentagePerMoth());
        investment.setCompoundInterest(createInvestmentDto.isCompoundInterest());
        investment.setNote(createInvestmentDto.getNote());
        investment.setStatus(StatusEnum.ACTIVE);

        investment = investmentRepository.createInvestments(investment);
        return investment;
    }

    @Override
    public void updateInvestment(String id, UpdateInvestmentDto updateInvestmentDto) {
        Investment investment = investmentRepository.getInvestmentsById(UUID.fromString(id));
        if (investment == null) {
            throw new BadRequest(INVESTMENT_NOT_FOUND);
        }
        investment.setOwner(updateInvestmentDto.getOwner());
        investment.setAmount(updateInvestmentDto.getAmount());
        investment.setCurrency(updateInvestmentDto.getCurrency());
        investment.setUpdateDate(LocalDateTime.now());
        investment.setPeriodInMonths(updateInvestmentDto.getPeriodInMonths());
        investment.setPercentagePerMoth(updateInvestmentDto.getPercentagePerMoth());
        investment.setCompoundInterest(updateInvestmentDto.isCompoundInterest());
        investment.setStatus(updateInvestmentDto.getStatus());
        investment.setNote(updateInvestmentDto.getNote());

        investmentRepository.updateInvestments(investment);
    }

    @Override
    public void changeStatus(String id, StatusEnum status) {
        Investment investment = investmentRepository.getInvestmentsById(UUID.fromString(id));
        if (investment == null) {
            throw new BadRequest(INVESTMENT_NOT_FOUND);
        }
        investment.setStatus(status);
        investmentRepository.changeStatus(UUID.fromString(id), status);
    }
}
