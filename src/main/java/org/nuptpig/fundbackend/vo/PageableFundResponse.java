package org.nuptpig.fundbackend.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PageableFundResponse {
    private Long total;

    @JsonProperty(value = "total_pages")
    private int totalPages;

    @JsonProperty(value = "funds")
    private List<FundResponse> fundResponseList;
}
