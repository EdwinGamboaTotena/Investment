package com.credence.investment.application.investment;

import com.credence.investment.domain.common.dto.PaginatorDto;
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
    private IInvestmentService service;

    @GetMapping
    public PaginatorDto<Investment> investmentList(@RequestParam int page, @RequestParam int size) {
        return service.get(page, size);
    }

    @GetMapping("/{id}")
    public Investment investmentById(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping
    public Investment createinvestment(@RequestBody CreateInvestmentDto dto, @RequestHeader String user) {
        return service.create(dto, user);
    }

    @PutMapping("/{id}")
    public void updateInvestment(@PathVariable String id, @RequestBody UpdateInvestmentDto dto) {
        service.update(id, dto);
    }

    @PatchMapping("/{id}")
    public void changeStatus(@PathVariable String id, @RequestParam boolean status) {
        service.changeStatus(id, status);
    }

}
