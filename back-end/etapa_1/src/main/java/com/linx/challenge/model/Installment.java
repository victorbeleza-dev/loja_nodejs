package com.linx.challenge.model;

import com.linx.challenge.model.pojo.Installment_POJO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Installment {

    private Integer count;

    private BigDecimal priceInstallment;

    public Installment(Installment_POJO installment) {
        this.count = installment.count;
        this.priceInstallment = installment.price;
    }
}
