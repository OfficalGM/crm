package com.crm.dataproviders.jpa.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "COMPANY_TABLE")
@Getter
@Setter
@EqualsAndHashCode(exclude = {})
@ToString(exclude = {})
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyEntity {

    @Id
    private Long id;

    private String name;

    private String address;

    private String createdBy;

    private Timestamp createdAt;

    private String updatedBy;

    private Timestamp updatedAt;

}
