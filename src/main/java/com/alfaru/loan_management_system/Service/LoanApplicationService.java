package com.alfaru.loan_management_system.Service;

import com.alfaru.loan_management_system.DTO.CreateLoanApplicationRequest;
import com.alfaru.loan_management_system.DTO.CreateLoanApplicationResponse;
import com.alfaru.loan_management_system.Entity.Customer;
import com.alfaru.loan_management_system.Entity.LoanApplication;
import com.alfaru.loan_management_system.Enum.CustomerStatus;
import com.alfaru.loan_management_system.Enum.LoanStatus;
import com.alfaru.loan_management_system.Repository.CustomerRepository;
import com.alfaru.loan_management_system.Repository.LoanApplicationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class LoanApplicationService {
    private final CustomerRepository customerRepository;
    private final LoanApplicationRepository loanApplicationRepository;


    public LoanApplicationService(CustomerRepository customerRepository,LoanApplicationRepository loanApplicationRepository){
        this.customerRepository = customerRepository;
        this.loanApplicationRepository = loanApplicationRepository;
    }


    public CreateLoanApplicationResponse submitLoanApplication(CreateLoanApplicationRequest request){
        //Find Customer
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(()->new RuntimeException("Customer not found"));
        //Validate Customer

        if(customer.getStatus() != CustomerStatus.ACTIVE){
            throw new RuntimeException("Customer is not active");

        }
        //Create loan application
        LoanApplication loanApplication = new LoanApplication();
        loanApplication.setCustomer(customer);
        loanApplication.setRequestedAmount(request.getRequestedAmount());
        loanApplication.setTermMonth(request.getTermMonths());
        loanApplication.setLoanType(request.getLoanType());
        loanApplication.setLoanPurpose(request.getLoanPurpose());
        loanApplication.setStatus(LoanStatus.SUBMITTED);
        loanApplication.setApplicationDate(LocalDate.now());


        //Save loan application

        LoanApplication savedApplication= loanApplicationRepository.save(loanApplication);

        return new CreateLoanApplicationResponse(
                savedApplication.getId(),
                savedApplication.getStatus().name(),
                "Loan application submitted successfully"
        );
    }






}
