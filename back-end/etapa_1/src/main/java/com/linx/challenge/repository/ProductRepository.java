package com.linx.challenge.repository;

import com.linx.challenge.model.Product;
import com.linx.challenge.model.dto.ProductDTO;
import com.linx.challenge.repository.criteriaqueries.ProductCriteriaQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, String>, ProductCriteriaQueries {

    @Query("select new com.linx.challenge.model.dto.ProductDTO(p.name, p.price, p.status) " +
            "from Product as p " +
            "where p.id = :id")
    Optional<ProductDTO> findCompactById(String id);

}
