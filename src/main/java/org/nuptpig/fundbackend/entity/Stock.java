package org.nuptpig.fundbackend.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "stock_tb")
public class Stock {
    @Id
    @Column(name = "stock_code")
    private String stockCode;

    @Column(name = "stock_name", nullable = false, unique = true)
    private String stockName;

    @OneToMany(mappedBy = "stock")
    Set<StockRating> ratings;
}
