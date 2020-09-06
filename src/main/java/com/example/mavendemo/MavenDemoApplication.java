package com.example.mavendemo;

import com.querydsl.jpa.impl.JPAQueryFactory;
import javax.persistence.EntityManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MavenDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(MavenDemoApplication.class, args);
  }
//  @Bean
//  public JPAQueryFactory jpaQueryFactory(EntityManager entityManager){
//    return new JPAQueryFactory(entityManager);
//  }
}
