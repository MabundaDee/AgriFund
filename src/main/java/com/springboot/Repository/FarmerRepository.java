package com.springboot.Repository;

import com.springboot.model.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmerRepository extends JpaRepository<Farmer,Long> {
}
