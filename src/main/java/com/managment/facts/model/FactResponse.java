package com.managment.facts.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class FactResponse {

    @JsonProperty("current_page")
    private Integer currentPage;
    private List<FactBody> data;

    @JsonProperty("first_page_url")
    private String firstPageUrl;

    private int from;
    @JsonProperty("last_page")
    private int lastPage;
    @JsonProperty("last_page_url")
    private String lastPageUrl;
    @JsonProperty("next_page_url")
    private String nextPageUrl;

    private String path;
    @JsonProperty("per_page")
    private int perPage;
    @JsonProperty("prev_page_url")
    private String prevPageUrl;
    private int to;
    private int total;

}
