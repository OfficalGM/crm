package com.crm.dataproviders.jpa.repo;

import com.crm.dataproviders.jpa.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<CompanyEntity, Long> {
}
