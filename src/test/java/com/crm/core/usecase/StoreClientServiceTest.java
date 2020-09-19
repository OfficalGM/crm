package com.crm.core.usecase;

import com.crm.core.vo.Client;
import com.crm.core.vo.Company;
import com.crm.core.vo.CreateClientParam;
import com.crm.core.vo.CreateCompanyParam;
import com.crm.port.StorePort;
import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StoreClientServiceTest {

    StoreClientService storeClientService;

    InMemoryStoreClientPort inMemoryStoreClientPort;

    @BeforeEach
    public void initCompanyService() {
        inMemoryStoreClientPort = new InMemoryStoreClientPort();
        storeClientService = new StoreClientService(inMemoryStoreClientPort);
    }

    @Test
    public void test_obtainAll_empty() {
        CreateClientParam param = CreateClientParam
                .builder()
                .build();

        final boolean result = storeClientService.create(param);

        assertThat(result).isTrue();

        assertThat(inMemoryStoreClientPort.getClientList()).hasSize(1);
    }

    @Test
    public void test_obtainAll() {
        CreateClientParam param1 = CreateClientParam
                .builder()
                .build();
        CreateClientParam param2 = CreateClientParam
                .builder()
                .build();

        final boolean result = storeClientService.create(List.of(param1, param2));

        assertThat(result).isTrue();

        assertThat(inMemoryStoreClientPort.getClientList()).hasSize(2);
    }

}

class InMemoryStoreClientPort implements StorePort<Client> {

    @Getter
    private final List<Client> clientList;

    public InMemoryStoreClientPort() {
        clientList = new ArrayList<>();
    }

    @Override
    public Client save(Client c) {
        clientList.add(c);
        c.setId((long) clientList.size());
        return c;
    }

    @Override
    public boolean save(List<Client> list) {
        clientList.addAll(list);
        return true;
    }
}