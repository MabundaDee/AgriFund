package com.springboot.Repository;

import com.springboot.model.Crops;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CropRepository extends JpaRepository <Crops,Long> {
}
