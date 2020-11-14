package org.nuptpig.fundbackend.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.nuptpig.fundbackend.entity.Fund;

import java.sql.Timestamp;

@Data
public class FundsInUserResponse {
    private Long id;

    @JsonProperty(value = "fund_code")
    private String fundCode;

    @JsonProperty(value = "fund")
    private Fund fund;

    @JsonProperty(value = "amount_held")
    private float amountHeld;

    @JsonProperty(value = "created_time")
    private Timestamp createdTime;

    @JsonProperty(value = "held_time")
    private Timestamp heldTime;
}
