package com.totoro.personnel.repository;

import com.totoro.personnel.model.JobType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ycd20 on 2022/06/11
 */
@Repository
public interface JobTypeRepository extends JpaRepository<JobType, Long> {

}
