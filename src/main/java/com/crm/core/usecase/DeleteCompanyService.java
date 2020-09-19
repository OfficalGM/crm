package com.crm.core.usecase;

import com.crm.core.vo.Company;
import com.crm.port.DeletePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class DeleteCompanyService {

    private final DeletePort<Company> deletePort;

    public boolean delete(long id) {
        if (id > 0) {
            return false;
        }
        return deletePort.delete(id);
    }

}
