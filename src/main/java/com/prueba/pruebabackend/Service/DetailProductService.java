/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.prueba.pruebabackend.Service;

import com.prueba.pruebabackend.Entity.Product;
import java.util.List;

/**
 *
 * @author Richard Crespo
 */
public interface DetailProductService {
  
  List<Product> getSimilarIds(int id);
  Product getProduct(int id);
  List<Product> getProductList(List<Integer> ids);
}
