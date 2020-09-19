package com.crm.dataproviders.jpa.util;

import com.crm.core.vo.Client;
import com.crm.dataproviders.jpa.entity.ClientEntity;
import lombok.experimental.UtilityClass;


@UtilityClass
public class ClientMapper {

    public ClientEntity mapToClientEntity(Client c) {
        return ClientEntity.builder()
                .companyId(c.getCompanyId())
                .name(c.getName())
                .address(c.getAddress())
                .email(c.getEmail())
                .createdBy(c.getCreatedBy())
                .createdAt(c.getCreatedAt())
                .updatedAt(c.getUpdatedAt())
                .updatedBy(c.getUpdatedBy())
                .build();
    }

    public Client mapToClient(ClientEntity entity) {
        return Client.builder()
                .id(entity.getId())
                .companyId(entity.getCompanyId())
                .name(entity.getName())
                .address(entity.getAddress())
                .email(entity.getEmail())
                .createdBy(entity.getCreatedBy())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .updatedBy(entity.getUpdatedBy())
                .build();
    }

}
