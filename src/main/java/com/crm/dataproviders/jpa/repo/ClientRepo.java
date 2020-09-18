package com.crm.dataproviders.jpa.repo;

import com.crm.dataproviders.jpa.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<ClientEntity, Long> {
}
