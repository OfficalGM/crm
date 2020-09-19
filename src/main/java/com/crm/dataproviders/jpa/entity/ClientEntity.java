package com.crm.dataproviders.jpa.entity;

import lombok.*;

import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
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
