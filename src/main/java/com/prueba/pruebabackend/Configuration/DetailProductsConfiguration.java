/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba.pruebabackend.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Richard Crespo
 */
@Configuration
public class DetailProductsConfiguration {

  @Bean("restClient")
  public RestTemplate registerRT() {
    RestTemplate rt = new RestTemplate(getClientHttpRequestFactory());
    return rt;
  }

  private ClientHttpRequestFactory getClientHttpRequestFactory() {
    int timeout = 5500;
    HttpComponentsClientHttpRequestFactory htcchrf
            = new HttpComponentsClientHttpRequestFactory();
    htcchrf.setConnectTimeout(timeout);
    htcchrf.setConnectionRequestTimeout(timeout);
    htcchrf.setReadTimeout(timeout);
    return htcchrf;
  }

}
