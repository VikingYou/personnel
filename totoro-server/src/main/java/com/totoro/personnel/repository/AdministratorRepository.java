package com.totoro.personnel.repository;

import com.totoro.personnel.model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by ycd20 on 2022/06/08
 */
@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {

    List<Administrator> findByIdIn(List<Long> tenantIds);


}
