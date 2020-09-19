package com.crm.core.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateClientParam {

    private Long companyId;

    private String name;

    private String email;

    private String phone;

    private String createdBy;

    private String updatedBy;

}
