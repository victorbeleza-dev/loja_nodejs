package com.linx.challenge.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.linx.challenge.model.Product;
import com.linx.challenge.model.dto.ProductDTO;
import com.linx.challenge.model.pojo.ProductPOJO;
import com.linx.challenge.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @PostConstruct
    private void saveData() {

        ObjectMapper mapper = new ObjectMapper();

        System.out.println("===> Loading data... Please, wait.");
        System.out.println("===> Loading data... READING JSON INPUT FILE");
        String errorLine = "";
        List<ProductPOJO> productsDTO = new ArrayList<>();
        try {
            Resource resource = new ClassPathResource("catalog.json");
            File myObj = resource.getFile();
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                errorLine = data;
                ProductPOJO productPOJO = mapper.readValue(data, ProductPOJO.class);
                productsDTO.add(productPOJO);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            System.err.println("Error during parsing -> "+ errorLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Product> products = Product.convertToProductList(productsDTO);
        System.out.println("===> Loading data... SAVING DATA INTO DATABASE");
        productRepository.saveAll(products);
        System.out.println("===> Loading data... DONE");
    }

    public Product findProductById(String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));
    }

    public ProductDTO findCompactProductById(String id) {
        ProductDTO productDTO = productRepository.findCompactById(id)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));
        productDTO.setCategories(productRepository.findProductCategories(id));
        return productDTO;
    }
}
