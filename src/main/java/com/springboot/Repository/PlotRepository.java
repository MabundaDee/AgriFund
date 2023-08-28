package com.springboot.Repository;

import com.springboot.model.Plot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlotRepository extends JpaRepository<Plot,Long> {
}
