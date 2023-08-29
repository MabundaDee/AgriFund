package com.springboot.Repository;

import com.springboot.model.IncomeStatement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeStatementRepository extends JpaRepository<IncomeStatement, Long> {
}
