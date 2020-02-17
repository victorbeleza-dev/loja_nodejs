package com.linx.challenge.model;

import com.linx.challenge.model.pojo.SpecPOJO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Spec {

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "cor")
    public  Cor cor;

    public Spec(SpecPOJO specPOJO) {
        this.cor = new Cor(specPOJO.cor);
    }
}
