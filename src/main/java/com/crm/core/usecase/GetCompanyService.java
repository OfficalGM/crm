package com.crm.core.usecase;

import com.crm.core.vo.Company;
import com.crm.port.GetCompanyPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class GetCompanyService {

    private final GetCompanyPort getCompanyPort;

    public List<Company> obtainAll() {
        return getCompanyPort.findAll();
    }

}
