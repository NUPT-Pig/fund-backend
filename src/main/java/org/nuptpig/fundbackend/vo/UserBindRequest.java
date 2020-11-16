package org.nuptpig.fundbackend.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class UserBindRequest {
    @JsonProperty(value = "user_name")
    private String userName;

    @JsonProperty(value = "fund_code")
    private String fundCode;

    @JsonProperty(value = "amount_held")
    private float amountHeld;

    @JsonProperty(value = "held_time")
    private Timestamp heldTime;
}
