package org.nuptpig.fundbackend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
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

    @ManyToMany
    @JoinTable(name = "stock_rating_tb", joinColumns = @JoinColumn(name = "fund_code"), inverseJoinColumns = @JoinColumn(name = "stock_code"))
    private List<Stock> stockList;
}
