/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba.pruebabackend.Controllers;

import com.prueba.pruebabackend.Entity.Product;
import com.prueba.pruebabackend.Service.DetailProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Richard Crespo
 */

@RestController
@RequestMapping("/product")
public class DetailProductController {
  
  @Autowired
  private DetailProductService service;
  
  @GetMapping("/{productId}/similar")
  public List<Product> getIds(@PathVariable Integer productId){
    return service.getSimilarIds(productId);
  }
  
}
