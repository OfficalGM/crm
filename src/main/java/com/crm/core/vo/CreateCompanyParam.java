package com.crm.core.vo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateCompanyParam {

    String name;

    String address;

    String createdBy;

    String updatedBy;

}
