package com.springboot.Repository;

import com.springboot.model.IncomeItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeItemsRepository extends JpaRepository<IncomeItems, Long> {
}
