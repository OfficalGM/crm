package com.crm.dataproviders.jpa.service;

import com.crm.core.vo.Company;
import com.crm.dataproviders.jpa.entity.CompanyEntity;
import com.crm.dataproviders.jpa.repo.CompanyRepo;
import com.crm.dataproviders.jpa.util.CompanyMapper;
import com.crm.port.GetPort;
import com.crm.port.ModifyPort;
import com.crm.port.StorePort;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class CompanyAdapter implements GetPort<Company>, StorePort<Company>, ModifyPort<Company> {

    private final CompanyRepo repo;

    public List<Company> findAll() {
        return repo.findAll()
                .stream()
                .map(CompanyMapper::mapToCompany)
                .collect(Collectors.toList());
    }

    @Override
    public Company save(final @NonNull Company company) {
        return CompanyMapper.mapToCompany(repo.save(CompanyMapper.mapToCompanyEntity(company)));
    }

    @Override
    public boolean save(List<Company> list) {
        final List<CompanyEntity> saveList = list.stream()
                .map(CompanyMapper::mapToCompanyEntity)
                .collect(Collectors.toList());
        repo.saveAll(saveList);
        return true;
    }

    @Override
    public long update(Company company) {
        final Optional<CompanyEntity> optional = repo.findById(company.getId())
                .map(e -> {
                    e.setName(company.getName());
                    e.setAddress(company.getAddress());
                    e.setUpdatedBy(company.getUpdatedBy());
                    e.setUpdatedAt(company.getUpdatedAt());
                    return e;
                }).map(repo::save);
        if (optional.isPresent()) {
            return optional.get().getId();
        }
        return 0L;
    }
}
