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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fund_id")
    private Long fundId;

    @Column(name = "fund_code", unique = true, nullable = false)
    private String fundCode;

    @Column(name = "fund_name", nullable = false, unique = true)
    private String fundName;

    @ManyToMany
    @JoinTable(name = "stock_rating_tb", joinColumns = @JoinColumn(name = "fund_id"), inverseJoinColumns = @JoinColumn(name = "stock_id"))
    private List<Stock> stockList;
}
