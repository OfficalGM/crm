package com.crm.dataproviders.jpa.service;

import com.crm.core.vo.Company;
import com.crm.dataproviders.jpa.repo.CompanyRepo;
import com.crm.dataproviders.jpa.util.CompanyMapper;
import com.crm.port.GetCompanyPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class CompanyAdapter implements GetCompanyPort {

    private final CompanyRepo repo;

    public List<Company> findAll() {
        return repo.findAll()
                .stream()
                .map(CompanyMapper::mapToCompany)
                .collect(Collectors.toList());
    }

    //TODO

}
