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
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
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
    try {
      Integer[] responseIds = restClient.getForObject("http://localhost:3001/product/{id}/similarids", Integer[].class, variables);
      List<Integer> ids = Arrays.asList(responseIds);
      List<Product> products = getProductList(ids);
      return products;
    } catch (RestClientException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
    }
  }

  @Override
  @Async
  public Product getProduct(int id) {

    Map<String, Integer> variables = new HashMap<String, Integer>();
    variables.put("id", id);
    Product product = new Product();
    try {
      product = restClient.getForObject("http://localhost:3001/product/{id}", Product.class, variables);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return product;
  }

  @Override
  public List<Product> getProductList(List<Integer> ids) {
    List<Product> products = new ArrayList<>();

    CompletableFuture<Product> id1 = CompletableFuture.supplyAsync(() -> getProduct(ids.get(0)));
    CompletableFuture<Product> id2 = CompletableFuture.supplyAsync(() -> getProduct(ids.get(1)));
    CompletableFuture<Product> id3 = CompletableFuture.supplyAsync(() -> getProduct(ids.get(2)));

    CompletableFuture.allOf(id1, id2, id3).join();

    try {
      Product p = id1.get();
      if(p.getId() != null){
        products.add(p);
      }
    } catch (InterruptedException | ExecutionException ex) {
      ex.printStackTrace();
    }
    try {
      Product p = id2.get();
      if(p.getId() != null){
        products.add(p);
      }
    } catch (InterruptedException | ExecutionException ex) {
      ex.printStackTrace();
    }
    try {
      Product p = id3.get();
      if(p.getId() != null){
        products.add(p);
      }
    } catch (InterruptedException | ExecutionException ex) {
      ex.printStackTrace();
    }

    return products;
  }

}
