/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba.pruebabackend.Service;

import com.prueba.pruebabackend.Entity.Product;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Richard Crespo
 */

@Slf4j
@Service
public class DetailProductServiceImpl implements DetailProductService {

  @Autowired
  private RestTemplate restClient;
  
  @Override
  public List<Product> getSimilarIds(int id) {
    Map<String, Integer> variables = new HashMap<String, Integer>();
    variables.put("id", id);
    try{
      Integer[] responseIds = restClient.getForObject("http://localhost:3001/product/{id}/similarids", Integer[].class, variables);
      List<Integer> ids = Arrays.asList(responseIds);
      List<Product> products = getProductList(ids);
      return products;
    }catch(RestClientException e){
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
    }
  }

  @Override
  public Product getProduct(int id) {
    Map<String, Integer> variables = new HashMap<String, Integer>();
    variables.put("id", id);
    Product product = restClient.getForObject("http://localhost:3001/product/{id}", Product.class, variables);
    return product;
  }

  @Override
  public List<Product> getProductList(List<Integer> ids) {
    List<Product> products = new ArrayList<>();
    
    ids.forEach(id -> {
      int itemId = id;
      Product pItem = getProduct(itemId);
      products.add(pItem);
    });
    
    return products;
  }
  
}
