package com.alfaru.loan_management_system.Controller;

import com.alfaru.loan_management_system.DTO.CreateLoanApplicationRequest;
import com.alfaru.loan_management_system.DTO.CreateLoanApplicationResponse;
import com.alfaru.loan_management_system.Entity.LoanApplication;
import com.alfaru.loan_management_system.Service.LoanApplicationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/loans")
public class LoanApplicationController {
    private final LoanApplicationService loanApplicationService;

    public LoanApplicationController(LoanApplicationService loanApplicationService){
        this.loanApplicationService = loanApplicationService;
    }


    @PostMapping
    public CreateLoanApplicationResponse createLoan(@RequestBody CreateLoanApplicationRequest request){
        return loanApplicationService.submitLoanApplication(request);
    }

}

