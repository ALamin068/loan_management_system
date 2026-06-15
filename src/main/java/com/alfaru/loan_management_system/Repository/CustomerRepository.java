package com.alfaru.loan_management_system.Repository;

import com.alfaru.loan_management_system.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CustomerRepository extends JpaRepository<Customer,Long> {


}
