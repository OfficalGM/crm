package com.crm.core.usecase;

import com.crm.core.vo.Company;
import com.crm.core.vo.ModifyParam;
import com.crm.port.ModifyPort;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Slf4j
@RequiredArgsConstructor
@Service
public class ModifyCompanyService {

    private final ModifyPort<Company> modifyPort;

    public boolean modify(final @NonNull ModifyParam param) {
        log.debug("modify param={}", param);
        final Company company = Company.builder()
                .id(param.getId())
                .name(param.getName())
                .address(param.getAddress())
                .updatedBy(param.getUpdatedBy())
                .updatedAt(Timestamp.from(Instant.now()))
                .build();
        final long result = modifyPort.update(company);
        return result != 0L;
    }

}
