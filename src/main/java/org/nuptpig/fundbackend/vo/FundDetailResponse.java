package org.nuptpig.fundbackend.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FundDetailResponse {
    @JsonProperty(value = "fund_code")
    private String fundCode;

    @JsonProperty(value = "fund_name")
    private String fundName;

    @JsonProperty(value = "stock_list")
    private List<StockInFundResponse> stocks;
}
