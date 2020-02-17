package com.linx.challenge.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.linx.challenge.model.pojo.CategoryPOJO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    private String id;

    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
    private List<Category> parents = null;

    @JsonIgnore
    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    List<Product> products;

    public Category(CategoryPOJO categoryPOJO) {
        this.id = categoryPOJO.getId();
        this.name = categoryPOJO.getName();
        this.parents = convertToCategoryParentList(categoryPOJO.getParents());
    }

    public Category(String parentCategory) {
        this.id = parentCategory;
        this.name = parentCategory;
    }

    private List<Category> convertToCategoryParentList(List<String> parents) {
        return parents.stream().map(Category::new).collect(Collectors.toList());
    }

    public static List<Category> convertToCategoryList(List<CategoryPOJO> categories) {
        return categories.stream().map(Category::new).collect(Collectors.toList());
    }
}
