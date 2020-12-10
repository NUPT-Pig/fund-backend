package org.nuptpig.fundbackend.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;
import org.nuptpig.fundbackend.entity.UserBinding.Status;
import java.util.List;

@Data
public class UserBindRequest {
    @JsonProperty(value = "fund_code")
    private String fundCode;

    @JsonProperty(value = "user_name")
    private String userName;

    private Status status;

    @JsonProperty(value = "amount_held")
    private double amountHeld=0;

    @JsonProperty(value = "held_time")
    private Timestamp heldTime;
}
