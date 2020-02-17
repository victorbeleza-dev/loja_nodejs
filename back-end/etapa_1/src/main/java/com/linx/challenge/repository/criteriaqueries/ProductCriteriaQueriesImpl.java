package com.linx.challenge.repository.criteriaqueries;

import com.linx.challenge.model.Category;
import com.linx.challenge.model.Product;
import com.linx.challenge.model.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.Optional;

public class ProductCriteriaQueriesImpl implements ProductCriteriaQueries {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Optional<ProductDTO> findCompactById(String id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProductDTO> query = builder.createQuery(ProductDTO.class);

        Root<Product> root = query.from(Product.class);
        Join<Product, Category> categoriesJoin = root.join("categories", JoinType.LEFT);
        root.fetch("categories").fetch("parents");

        query.multiselect(root.get("name"), root.get("price"), root.get("status"));

        query.where(builder.equal(
                root.get("id"), id
        ));

        return entityManager.createQuery(query).getResultList().stream().findFirst();
    }

    @Override
    public List<Category> findProductCategories(String productId) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Category> query = builder.createQuery(Category.class);

        Root<Category> root = query.from(Category.class);
        Join<Category, Product> productJoin = root.join("products");
        root.fetch("parents", JoinType.LEFT);

        query.select(root);

        query.where(builder.equal(
                productJoin.get("id"), productId
        ));

        return entityManager.createQuery(query).getResultList();
    }

}