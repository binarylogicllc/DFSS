package com.ca.scheduler.core.domain;

import com.ca.scheduler.core.domain.values.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "card_input_file")
@Data
@EqualsAndHashCode(callSuper=false)
public class CardInputFile extends EntityAudit{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "card_input_file_seq")
    @SequenceGenerator(
            name = "card_input_file_seq",
            sequenceName = "card_input_file_id_seq",
            allocationSize = 1
    )
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "CUSTOMER_ID")
    private Long customer;

    @Column(name = "CARD_NO")
    private String cardNo;

    @Column(name = "start_range")
    private String startRange;

    @Column(name = "end_range")
    private String endRange;

    @Column(name = "create_type")
    @Enumerated(EnumType.STRING)
    private CardCreateType createType;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_download_url")
    private String fileDownloadUrl;

}
