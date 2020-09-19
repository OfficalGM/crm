package com.crm.core.usecase;

import com.crm.core.vo.Company;
import com.crm.core.vo.CreateCompanyParam;
import com.crm.port.GetPort;
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
public class StoreCompanyService {

    private final StorePort<Company> storePort;

    public boolean create(CreateCompanyParam param) {
        log.debug("create() param={}", param);
        final Company savedCompany = storePort.save(toCompany(param));
        return savedCompany.getId() != null;
    }

    public boolean create(List<CreateCompanyParam> paramList) {
        log.debug("create() paramList size={}", paramList.size());
        final List<Company> companyList = paramList.stream()
                .map(this::toCompany)
                .collect(Collectors.toList());
        final boolean result = storePort.save(companyList);
        log.debug("create() result={}", result);
        return result;
    }

    private Company toCompany(CreateCompanyParam param) {
        final Timestamp now = Timestamp.from(Instant.now());
        return Company.builder()
                .address(param.getAddress())
                .name(param.getAddress())
                .createdBy(param.getCreatedBy())
                .updatedBy(param.getUpdatedBy())
                .createdAt(now)
                .updatedAt(now)
                .build();
    }

}
