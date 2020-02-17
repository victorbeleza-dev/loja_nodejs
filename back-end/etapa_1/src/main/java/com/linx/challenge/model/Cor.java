package com.linx.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cor {

    @Id
    public String id;

    public String label;

    public Cor(String cor) {
        this.id = cor;
        this.label = cor;
    }
}
