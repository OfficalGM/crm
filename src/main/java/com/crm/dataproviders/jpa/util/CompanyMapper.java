package com.crm.dataproviders.jpa.util;

import com.crm.core.vo.Company;
import com.crm.dataproviders.jpa.entity.CompanyEntity;
import lombok.experimental.UtilityClass;


@UtilityClass
public class CompanyMapper {

    public CompanyEntity mapToCompanyEntity(Company c) {
        return CompanyEntity.builder()
                .name(c.getName())
                .address(c.getAddress())
                .createdBy(c.getCreatedBy())
                .createdAt(c.getCreatedAt())
                .updatedAt(c.getUpdatedAt())
                .updatedBy(c.getUpdatedBy())
                .build();
    }

    public Company mapToCompany(CompanyEntity entity) {
        return Company.builder()
                .id(entity.getId())
                .name(entity.getName())
                .address(entity.getAddress())
                .createdBy(entity.getCreatedBy())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .updatedBy(entity.getUpdatedBy())
                .build();
    }

}
