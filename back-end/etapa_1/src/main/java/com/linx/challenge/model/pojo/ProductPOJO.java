
package com.linx.challenge.model.pojo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "imagesSsl",
        "skus",
        "apiKey",
        "description",
        "type",
        "auditInfo",
        "specs",
        "eanCode",
        "price",
        "details",
        "remoteUrl",
        "categories",
        "id",
        "stock",
        "brand",
        "customBusiness",
        "basePrice",
        "images",
        "kitProducts",
        "created",
        "oldPrice",
        "published",
        "version",
        "url",
        "tags",
        "unit",
        "installment",
        "name",
        "clientLastUpdated",
        "extraInfo",
        "status",
        "ungroupedId"
})
public class ProductPOJO {

    @JsonProperty("imagesSsl")
    public ImagesSslPOJO imagesSsl;

    @JsonProperty("skus")
    public List<SkuPOJO> skus = null;

    @JsonProperty("apiKey")
    public String apiKey;

    @JsonProperty("description")
    public String description;

    @JsonProperty("type")
    public String type;

    @JsonProperty("auditInfo")
    public AuditInfoPOJO auditInfo;

    @JsonProperty("specs")
    public Specs_POJO specs;

    @JsonProperty("eanCode")
    public String eanCode;

    @JsonProperty("price")
    public BigDecimal price;

    @JsonProperty("details")
    public Details_POJO details;

    @JsonProperty("remoteUrl")
    public String remoteUrl;

    @JsonProperty("categories")
    public List<CategoryPOJO> categories = null;

    @JsonProperty("id")
    public String id;

    @JsonProperty("stock")
    public Object stock;

    @JsonProperty("brand")
    public String brand;

    @JsonProperty("customBusiness")
    public CustomBusiness_POJO customBusiness;

    @JsonProperty("basePrice")
    public BigDecimal basePrice;

    @JsonProperty("images")
    public Map<String, String> images;

    @JsonProperty("kitProducts")
    public List<Object> kitProducts = null; // empty

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("created")
    public String created;

    @JsonProperty("oldPrice")
    public BigDecimal oldPrice;

    @JsonProperty("published")
    public Object published;

    @JsonProperty("version")
    public String version;

    @JsonProperty("url")
    public String url;

    @JsonProperty("tags")
    public List<Object> tags = null; // empty

    @JsonProperty("unit")
    public Object unit; // empty

    @JsonProperty("installment")
    public Installment_POJO installment;

    @JsonProperty("name")
    public String name;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("clientLastUpdated")
    public String clientLastUpdated;

    @JsonProperty("extraInfo")
    public ExtraInfoPOJO extraInfo;

    @JsonProperty("status")
    public String status;

    @JsonProperty("ungroupedId")
    public String ungroupedId;

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
