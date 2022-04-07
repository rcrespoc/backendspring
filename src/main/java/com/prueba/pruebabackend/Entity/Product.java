/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba.pruebabackend.Entity;

import lombok.Data;

/**
 *
 * @author Richard Crespo
 */
@Data
public class Product {
  
  String id;
  String name;
  Double price;
  boolean availability;
  
}
