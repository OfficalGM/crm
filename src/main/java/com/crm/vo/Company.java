package com.crm.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Company {

    private Long id;

    private String name;

    private String address;

    private String createdBy;

    private Timestamp createdAt;

    private String updatedBy;

    private Timestamp updatedAt;

}
