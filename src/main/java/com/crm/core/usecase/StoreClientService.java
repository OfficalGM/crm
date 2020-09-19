package com.crm.core.usecase;


import com.crm.core.vo.Client;
import com.crm.core.vo.Company;
import com.crm.core.vo.CreateClientParam;
import com.crm.core.vo.CreateCompanyParam;
import com.crm.port.StorePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@RequiredArgsConstructor
@Service
public class StoreClientService {

    private final StorePort<Client> storePort;

    public boolean create(CreateClientParam param) {
        log.debug("create() param={}", param);
        final Client savedClient = storePort.save(toClient(param));
        return savedClient.getId() != null;
    }

    public boolean create(List<CreateClientParam> paramList) {
        log.debug("create() paramList size={}", paramList.size());
        final List<Client> clientList = paramList.stream()
                .map(this::toClient)
                .collect(Collectors.toList());
        final boolean result = storePort.save(clientList);
        log.debug("create() result={}", result);
        return result;
    }

    private Client toClient(CreateClientParam param) {
        final Timestamp now = Timestamp.from(Instant.now());
        return Client.builder()
                .companyId(param.getCompanyId())
                .name(param.getName())
                .email(param.getEmail())
                .createdBy(param.getCreatedBy())
                .updatedBy(param.getUpdatedBy())
                .createdAt(now)
                .updatedAt(now)
                .build();
    }

}
