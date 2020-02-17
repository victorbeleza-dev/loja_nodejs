package com.linx.challenge.model.dto;

import com.linx.challenge.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private String name;

    private BigDecimal price;

    private String status;

    private List<Category> categories;

    public ProductDTO(String name, BigDecimal price, String status) {
        this.name = name;
        this.price = price;
        this.status = status;
    }
}
