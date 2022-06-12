package com.totoro.personnel.repository;

import com.totoro.personnel.model.JobLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ycd20 on 2022/06/12
 */
@Repository
public interface JobLevelRepository extends JpaRepository<JobLevel,Long> {
}
