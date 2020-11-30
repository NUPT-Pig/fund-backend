package org.nuptpig.fundbackend.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.nuptpig.fundbackend.entity.Fund;

import java.util.List;

@Data
public class StockInFundResponse {
    @JsonProperty(value = "stock_code")
    private String stockCode;

    @JsonProperty(value = "stock_name")
    private String stockName;

    private float rate;

    private List<FundResponse> funds;
}
