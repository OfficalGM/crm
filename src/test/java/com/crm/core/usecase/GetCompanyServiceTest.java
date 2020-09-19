package com.crm.core.usecase;

import com.crm.core.vo.Company;
import com.crm.port.GetPort;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GetCompanyServiceTest {

    GetCompanyService getCompanyService;

    public void initEmptyCompanyService() {
        getCompanyService = new GetCompanyService(new EmptyGetPort());
    }

    public void initCompanyService() {
        getCompanyService = new GetCompanyService(new FakeGetPort());
    }

    @Test
    public void test_obtainAll_empty() {
       initEmptyCompanyService();

        List<Company> resultList = getCompanyService.obtainAll();

        assertThat(resultList).isEmpty();
    }

    @Test
    public void test_obtainAll() {
        initCompanyService();

        List<Company> resultList = getCompanyService.obtainAll();

        assertThat(resultList).hasSize(1);
    }
}

class FakeGetPort implements GetPort {

    private final List<Company> companyList;

    public FakeGetPort() {
        this.companyList = new ArrayList<>();
    }

    @Override
    public List<Company> findAll() {
        companyList.add(Company.builder().build());
        return companyList;
    }
}

class EmptyGetPort implements GetPort {

    @Override
    public List<Company> findAll() {
        return List.of();
    }
}