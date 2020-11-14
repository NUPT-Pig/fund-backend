package org.nuptpig.fundbackend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "stock_tb")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_code")
    private String stockCode;

    @Column(name = "stock_name", nullable = false, unique = true)
    private String stockName;

    @ManyToMany(mappedBy = "stockList")
    private List<Fund> fundList;
}
