package com.alfaru.loan_management_system.Entity;


import com.alfaru.loan_management_system.Enum.ScheduleStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "payment_schedule")
public class RepaymentSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "loan_application_id",nullable = false)
    private LoanApplication loanApplication;
    private LocalDate dueDate;
    private BigDecimal principalAmount;
    private BigDecimal interestAmount;
    private BigDecimal totalDue;
    private BigDecimal remainaingBalance;
    private ScheduleStatus status;

}
