package com.alfaru.loan_management_system.DTO;

public class CreateLoanApplicationResponse {
    private long id;
    private String status;
    private String message;


    public CreateLoanApplicationResponse(Long id, String status,String message){
        this.id = id;
        this.status=status;
        this.message=message;
    }
}
