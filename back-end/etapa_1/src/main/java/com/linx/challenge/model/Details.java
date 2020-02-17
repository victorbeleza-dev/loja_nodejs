package com.linx.challenge.model;

import com.linx.challenge.model.pojo.Details_POJO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Details {

//    private String name;

    private String hexaColor;

//    private String brand;

    private String rating;

    private String codVenda;

    private BigDecimal precoavista;

    public Details(Details_POJO details) {
        this.hexaColor = details.hexaColor;
        this.rating = details.rating;
        this.codVenda = details.codVenda;
        this.precoavista = details.precoavista;
    }
}
