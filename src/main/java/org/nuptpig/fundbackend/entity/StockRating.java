package org.nuptpig.fundbackend.entity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Data
@Entity
@Table(name = "stock_rating_tb")
class StockRating {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fund_code")
    Fund fund;

    @ManyToOne
    @JoinColumn(name = "stock_code")
    Stock stock;
}


//@Embeddable
//class StockRatingKey implements Serializable {
//
//    @Column(name = "fund_id")
//    private long fundId;
//
//    @Column(name = "stock_id")
//    private long stockId;
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        StockRatingKey that = (StockRatingKey) o;
//        return fundId == that.fundId &&
//                stockId == that.stockId;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(fundId, stockId);
//    }
//}

//@Entity
//@Data
//public class StockRating {
//    @EmbeddedId
//    private StockRatingKey id;
//
//    @ManyToOne
//    @MapsId("fundId")
//    @JoinColumn(name = "fund_id")
//    Fund fund;
//
//    @ManyToOne
//    @MapsId("stockId")
//    @JoinColumn(name = "stock_id")
//    Stock stock;
//
//    int rating;
//}
