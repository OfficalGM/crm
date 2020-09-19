package com.crm.core.usecase;

import com.crm.core.vo.Company;
import com.crm.port.GetPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class GetCompanyService {

    private final GetPort<Company> getPort;

    public List<Company> obtainAll() {
        return getPort.findAll();
    }

}
