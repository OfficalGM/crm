package com.crm.core.usecase;

import com.crm.core.vo.Client;
import com.crm.core.vo.Company;
import com.crm.core.vo.ModifyClientParam;
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
public class ModifyClientService {

    private final ModifyPort<Client> modifyPort;

    public boolean modify(final @NonNull ModifyClientParam param) {
        log.debug("modify param={}", param);
        final Client client = Client.builder()
                .id(param.getId())
                .companyId(param.getCompanyId())
                .name(param.getName())
                .email(param.getEmail())
                .updatedBy(param.getUpdatedBy())
                .updatedAt(Timestamp.from(Instant.now()))
                .build();
        final long result = modifyPort.update(client);
        return result != 0L;
    }

}
