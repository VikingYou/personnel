package com.totoro.personnel.repository;

import com.totoro.personnel.model.SalaryItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ycd20 on 2022/06/14
 */
public interface SalaryAccountRepository extends JpaRepository<Long, SalaryItem> {
}
