package com.example.mavendemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parkingLots")
public class Controller {
  @GetMapping
  public String hello() {
    return "hello";
  }
}
