package com.alfaru.loan_management_system.Service;

import com.alfaru.loan_management_system.DTO.CreateLoanApplicationRequest;
import com.alfaru.loan_management_system.Entity.Customer;
import com.alfaru.loan_management_system.Entity.LoanApplication;
import com.alfaru.loan_management_system.Enum.CustomerStatus;
import com.alfaru.loan_management_system.Repository.CustomerRepository;
import com.alfaru.loan_management_system.Repository.LoanApplicationRepository;
import org.springframework.stereotype.Service;

@Service
public class LoanApplicationService {
    private final CustomerRepository customerRepository;
    private final LoanApplicationRepository loanApplicationRepository;


    public LoanApplicationService(CustomerRepository customerRepository,LoanApplicationRepository loanApplicationRepository){
        this.customerRepository = customerRepository;
        this.loanApplicationRepository = loanApplicationRepository;
    }


    public void submitLoanApplication(CreateLoanApplicationRequest request){
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


        //Sava loan application

        LoanApplication application = loanApplicationRepository.save(loanApplication);



    }






}
