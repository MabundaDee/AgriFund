package com.springboot.Repository;

import com.springboot.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepository extends JpaRepository <Asset,Long> {

}
