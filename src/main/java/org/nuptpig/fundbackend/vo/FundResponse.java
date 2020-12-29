package org.nuptpig.fundbackend.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.nuptpig.fundbackend.entity.UserBinding.Status;

@Data
public class FundResponse {
    @JsonProperty(value = "fund_id")
    private Long fundId;

    @JsonProperty(value = "fund_code")
    private String fundCode;

    @JsonProperty(value = "fund_name")
    private String fundName;

    private Status status;
}
