package org.nuptpig.fundbackend.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StockInFundResponse {
    @JsonProperty(value = "stock_code")
    private String stockCode;

    @JsonProperty(value = "stock_name")
    private String stockName;

    private float rate;


}
