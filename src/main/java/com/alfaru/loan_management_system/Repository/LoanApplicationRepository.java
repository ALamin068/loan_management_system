package com.alfaru.loan_management_system.Repository;

import com.alfaru.loan_management_system.Entity.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long> {
}
