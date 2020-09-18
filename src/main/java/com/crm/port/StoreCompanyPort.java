package com.crm.port;

import com.crm.core.vo.Company;

interface StoreCompanyPort {

    Company save(Company company);

    //TODO save all
}
