package org.nuptpig.fundbackend.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FundRequest {
    @JsonProperty(value = "fund_code")
    private String fundCode;

    @JsonProperty(value = "fund_name")
    private String fundName;
}
