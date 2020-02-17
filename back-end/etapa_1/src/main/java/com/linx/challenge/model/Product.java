package com.linx.challenge.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.linx.challenge.model.pojo.ProductPOJO;
import com.linx.challenge.utils.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @JsonProperty("id")
    private String id;

//    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
//    List<Sku> skus;

    private String apiKey;

    @Lob
    @Column
    private String description;

    private String type;

    @Embedded
    private AuditInfo auditInfo;

    private String eanCode;

    private BigDecimal price;

    @Embedded
    private Details details;

    private String remoteUrl;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private List<Category> categories;

    private String brand;

    private BigDecimal basePrice;

    @OneToMany(cascade = {CascadeType.ALL})
    List<Image> images;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created;

    private BigDecimal oldPrice;

    private String version;

    private String url;

    @Embedded
    private Installment installment;

    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime clientLastUpdated;

    @Embedded
    private ExtraInfo extraInfo;

    private String status;

    private String ungroupedId;

    public Product(ProductPOJO productPOJO) {
        this.id = productPOJO.getId();
//        this.skus = Sku.convertToSkuList(productDTO.getSkus());
        this.apiKey = productPOJO.getApiKey();
        this.description = productPOJO.getDescription();
        this.type = productPOJO.getType();
        this.auditInfo = new AuditInfo(productPOJO.getAuditInfo());
        this.eanCode = productPOJO.eanCode;
        this.price = productPOJO.price;
        this.details = new Details(productPOJO.details);
        this.remoteUrl = productPOJO.getRemoteUrl();
        this.categories = Category.convertToCategoryList(productPOJO.getCategories());
        this.brand = productPOJO.getBrand();
        this.basePrice = productPOJO.getBasePrice();
        this.images = Image.convertToImageList(productPOJO.getImages());
        this.created = DateUtils.convertStringToLocalDateTime(productPOJO.getCreated());
        this.oldPrice = productPOJO.getOldPrice();
        this.version = productPOJO.getVersion();
        this.url = productPOJO.getUrl();
        this.installment = new Installment(productPOJO.getInstallment());
        this.name = productPOJO.getName();
        this.clientLastUpdated = DateUtils.convertStringToLocalDateTime(productPOJO.getClientLastUpdated());
        this.extraInfo = new ExtraInfo(productPOJO.getExtraInfo());
        this.status = productPOJO.getStatus();
        this.ungroupedId = productPOJO.getUngroupedId();

    }

    public static List<Product> convertToProductList(List<ProductPOJO> productsDTO) {
        return productsDTO.stream().map(Product::new).collect(Collectors.toList());
    }
}
