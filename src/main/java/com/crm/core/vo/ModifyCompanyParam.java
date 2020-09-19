package com.crm.core.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ModifyCompanyParam {

    private Long id;

    private String name;

    private String address;

    private String updatedBy;

}
