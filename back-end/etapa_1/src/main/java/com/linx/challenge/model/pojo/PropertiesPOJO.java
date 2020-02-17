
package com.linx.challenge.model.pojo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "installment",
        "images",
        "price",
        "url",
        "details",
        "status",
        "oldPrice"
})
public class PropertiesPOJO {

    @JsonProperty("name")
    public String name;

    @JsonProperty("installment")
    public InstallmentPOJO installment;

    @JsonProperty("images")
    public Map<String, String> images;

    @JsonProperty("price")
    public BigDecimal price;

    @JsonProperty("url")
    public String url;

    @JsonProperty("details")
    public DetailsPOJO details;

    @JsonProperty("status")
    public String status;

    @JsonProperty("oldPrice")
    public BigDecimal oldPrice;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
