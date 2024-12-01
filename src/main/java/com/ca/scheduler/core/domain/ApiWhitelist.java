package com.ca.scheduler.core.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "API_WHITELIST" , schema = "public")
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
public class ApiWhitelist extends EntityAudit{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "api_whitelist_seq")
    @SequenceGenerator(
            name = "api_whitelist_seq",
            sequenceName = "api_whitelist_id_seq",
            allocationSize = 1
    )
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "user_id")
    private Long user;

    @Column(name = "x_channel")
    private String xChannel;

    @Column(name = "x_api_key")
    private String xApiKey;

    @Column(name = "allowed_api_list")
    private String allowedApiList;

}
