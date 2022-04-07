/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba.pruebabackend.Controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Richard Crespo
 */
@RestController
public class ErrorHandlerController implements ErrorController{
  
  @RequestMapping(value = "/error", produces = {"text/plain"})
  @ResponseBody
  public String getErrorPath(){
    return "Product not found";
  }
  
}
