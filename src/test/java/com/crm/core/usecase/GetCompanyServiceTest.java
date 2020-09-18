package com.crm.core.usecase;

import com.crm.core.vo.Company;
import com.crm.port.GetCompanyPort;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GetCompanyServiceTest {

    GetCompanyService getCompanyService;

    public GetCompanyService initEmptyCompanyService() {
        getCompanyService = new GetCompanyService(new EmptyGetCompanyPort());
        return getCompanyService;
    }

    public GetCompanyService initCompanyService() {
        getCompanyService = new GetCompanyService(new FakeGetCompanyPort());
        return getCompanyService;
    }

    @Test
    public void test_obtainAll_empty() {
        getCompanyService = initEmptyCompanyService();

        List<Company> resultList = getCompanyService.obtainAll();

        assertThat(resultList).isEmpty();
    }

    @Test
    public void test_obtainAll() {
        getCompanyService = initCompanyService();

        List<Company> resultList = getCompanyService.obtainAll();

        assertThat(resultList).hasSize(1);
    }
}

class FakeGetCompanyPort implements GetCompanyPort {

    private final List<Company> companyList;

    public FakeGetCompanyPort() {
        this.companyList = new ArrayList<>();
    }

    @Override
    public List<Company> findAll() {
        companyList.add(Company.builder().build());
        return companyList;
    }
}

class EmptyGetCompanyPort implements GetCompanyPort {

    @Override
    public List<Company> findAll() {
        return List.of();
    }
}