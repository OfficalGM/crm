package com.crm.port;

import com.crm.core.vo.Company;

import java.util.List;

public interface GetCompanyPort {

    List<Company> findAll();

}
