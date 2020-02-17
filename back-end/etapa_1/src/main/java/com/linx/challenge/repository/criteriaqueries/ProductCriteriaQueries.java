package com.linx.challenge.repository.criteriaqueries;

import com.linx.challenge.model.Category;
import com.linx.challenge.model.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductCriteriaQueries {

    Optional<ProductDTO> findCompactById(String id);

    List<Category> findProductCategories(String productId);
}
