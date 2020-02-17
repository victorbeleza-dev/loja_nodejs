
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "HexaColor",
        "brand",
        "rating",
        "cod_venda",
        "precoavista"
})
public class Details_POJO {

    @JsonProperty("name")
    public String name;

    @JsonProperty("HexaColor")
    public String hexaColor;

    @JsonProperty("brand")
    public String brand;

    @JsonProperty("rating")
    public String rating;

    @JsonProperty("cod_venda")
    public String codVenda;

    @JsonProperty("precoavista")
    public BigDecimal precoavista;

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
