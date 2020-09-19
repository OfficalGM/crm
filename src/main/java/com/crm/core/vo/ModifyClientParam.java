package com.crm.core.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ModifyClientParam {

    private Long id;

    private Long companyId;

    private String name;

    private String email;

    private String phone;

    private String updatedBy;

}
