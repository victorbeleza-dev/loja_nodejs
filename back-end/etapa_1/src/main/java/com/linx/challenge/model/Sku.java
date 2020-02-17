package com.linx.challenge.model;

import com.linx.challenge.model.pojo.SkuPOJO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sku {

    @Id
    private String sku;

    @Embedded
    private Spec specs;

    @Embedded
    private Properties properties;

    public Sku (SkuPOJO skuPOJO) {
        this.sku = skuPOJO.getSku();
        this.specs = new Spec(skuPOJO.specs);
        this.properties = new Properties(skuPOJO.getProperties());
    }

    public static List<Sku> convertToSkuList(List<SkuPOJO> skus) {
        return skus.stream().map(Sku::new).collect(Collectors.toList());
    }
}
