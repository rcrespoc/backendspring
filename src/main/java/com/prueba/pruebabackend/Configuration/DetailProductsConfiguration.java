/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba.pruebabackend.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Richard Crespo
 */

@Configuration
public class DetailProductsConfiguration {
  
  @Bean("restClient")
  public RestTemplate registerRT(){
    return new RestTemplate();
  }
  
}
