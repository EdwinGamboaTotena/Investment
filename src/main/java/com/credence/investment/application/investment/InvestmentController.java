package com.credence.investment.application.investment;

import com.credence.investment.domain.common.dto.PaginatorDto;
import com.credence.investment.domain.common.enums.StatusEnum;
import com.credence.investment.domain.investment.Investment;
import com.credence.investment.domain.investment.dto.CreateInvestmentDto;
import com.credence.investment.domain.investment.dto.UpdateInvestmentDto;
import com.credence.investment.domain.investment.ports.IInvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/investments")
public class InvestmentController {

    @Autowired
    private IInvestmentService investmentService;

    @GetMapping
    public PaginatorDto<Investment> investmentList(@RequestParam int page, @RequestParam int size) {
        return investmentService.getInvestmentsList(page, size);
    }

    @GetMapping("/{id}")
    public Investment investmentById(@PathVariable String id) {
        return investmentService.getInvestmentById(id);
    }

    @PostMapping
    public Investment createinvestment(@RequestBody CreateInvestmentDto dto) {
        return investmentService.createInvestment(dto);
    }

    @PutMapping("/{id}")
    public void updateInvestment(@PathVariable String id, @RequestBody UpdateInvestmentDto dto) {
        investmentService.updateInvestment(id, dto);
    }

    @PatchMapping("/{id}")
    public void changeStatus(@PathVariable String id, @RequestParam StatusEnum status) {
        investmentService.changeStatus(id, status);
    }

}
