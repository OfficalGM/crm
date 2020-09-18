package com.crm.dataproviders.jpa.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "CLIENT_TABLE")
@Getter
@Setter
@EqualsAndHashCode(exclude = {})
@ToString(exclude = {})
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientEntity {

    @Id
    private Long id;

    private Long companyId;

    private String name;

    private String address;

    private String email;

    private String createdBy;

    private Timestamp createdAt;

    private String updatedBy;

    private Timestamp updatedAt;

}
