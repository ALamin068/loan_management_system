package com.alfaru.loan_management_system.Entity;

import com.alfaru.loan_management_system.Enum.PaymentMethod;
import com.alfaru.loan_management_system.Enum.PaymentStatus;
import com.alfaru.loan_management_system.Entity.RepaymentSchedule;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table( name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "repayment_schedule_id", nullable = false)
    private LoanApplication loanApplication;
    @ManyToOne
    @JoinColumn(name = "repayment_schedule_id",nullable = false)
    private RepaymentSchedule repaymentSchedule;
    private LocalDateTime paymentDate;
    private BigDecimal amountPaid;
    private PaymentMethod paymentMethod;
    private String transactionReference;
    private PaymentStatus status;
}
