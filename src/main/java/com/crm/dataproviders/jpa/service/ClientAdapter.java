package com.crm.dataproviders.jpa.service;

import com.crm.core.vo.Company;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ClientAdapter {


    public List<Company> obtainAll() {
        return List.of();
    }

}
