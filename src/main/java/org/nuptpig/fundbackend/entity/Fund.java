package org.nuptpig.fundbackend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name="fund_tb")
public class Fund {
    @Id
    @Column(name = "fund_code")
    private String fundCode;

    @Column(name = "fund_name", nullable = false, unique = true)
    private String fundName;

    @OneToMany(mappedBy = "fund")
    Set<StockRating> ratings;
}
