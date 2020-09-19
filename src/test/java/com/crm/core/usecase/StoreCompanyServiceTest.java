package com.crm.core.usecase;

import com.crm.core.vo.Company;
import com.crm.core.vo.CreateCompanyParam;
import com.crm.port.StorePort;
import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StoreCompanyServiceTest {

    StoreCompanyService storeCompanyService;

    InMemoryStorePort inMemoryStorePort;

    @BeforeEach
    public void initCompanyService() {
        inMemoryStorePort = new InMemoryStorePort();
        storeCompanyService = new StoreCompanyService(inMemoryStorePort);
    }

    @Test
    public void test_obtainAll_empty() {
        CreateCompanyParam param = CreateCompanyParam
                .builder()
                .build();

        final boolean result = storeCompanyService.create(param);

        assertThat(result).isTrue();

        assertThat(inMemoryStorePort.getCompanyList()).hasSize(1);
    }

    @Test
    public void test_obtainAll() {
        CreateCompanyParam param1 = CreateCompanyParam
                .builder()
                .build();
        CreateCompanyParam param2 = CreateCompanyParam
                .builder()
                .build();

        final boolean result = storeCompanyService.create(List.of(param1, param2));

        assertThat(result).isTrue();

        assertThat(inMemoryStorePort.getCompanyList()).hasSize(2);
    }

}

class InMemoryStorePort implements StorePort<Company> {

    @Getter
    private final List<Company> companyList;

    public InMemoryStorePort() {
        companyList = new ArrayList<>();
    }

    @Override
    public Company save(Company company) {
        companyList.add(company);
        company.setId((long) companyList.size());
        return company;
    }

    @Override
    public boolean save(List<Company> list) {
        companyList.addAll(list);
        return true;
    }
}