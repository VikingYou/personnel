package com.totoro.personnel.repository;

import com.totoro.personnel.model.SalaryType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ycd20 on 2022/06/14
 */
public interface SalaryTypeRepository extends JpaRepository<Long, SalaryType> {
}
