package com.totoro.personnel.repository;

import com.totoro.personnel.model.Tenant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by ycd20 on 2022/06/07
 */
@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {
    @Override
    Optional<Tenant> findById(Long aLong);

    Page<Tenant> findByCreatedBy(Long userId, Pageable pageable);

    long countByCreatedBy(Long userId);

    List<Tenant> findByIdIn(List<Long> tenantIds);

    List<Tenant> findByIdIn(List<Long> tenantIds, Sort sort);
}
