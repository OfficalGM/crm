package com.crm.core.usecase;

import com.crm.core.vo.Client;
import com.crm.port.GetPort;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GetClientServiceTest {
    GetClientService getClientService;

    public void initEmptyCompanyService() {
        getClientService = new GetClientService(new EmptyGetClientPort());
    }

    public void initCompanyService() {
        getClientService = new GetClientService(new FakeGetClientPort());
    }

    @Test
    public void test_obtainAll_empty() {
        initEmptyCompanyService();

        List<Client> resultList = getClientService.obtainAll();

        assertThat(resultList).isEmpty();
    }

    @Test
    public void test_obtainAll() {
        initCompanyService();

        List<Client> resultList = getClientService.obtainAll();

        assertThat(resultList).hasSize(1);
    }
}

class FakeGetClientPort implements GetPort<Client> {

    private final List<Client> clientList;

    public FakeGetClientPort() {
        this.clientList = new ArrayList<>();
    }

    @Override
    public List<Client> findAll() {
        clientList.add(Client.builder().build());
        return clientList;
    }
}

class EmptyGetClientPort implements GetPort<Client> {

    @Override
    public List<Client> findAll() {
        return List.of();
    }
}