package com.example.mavendemo.service.impl;

import com.example.mavendemo.dto.ParkingLotDto;
import com.example.mavendemo.entity.ParkingLot;
import com.example.mavendemo.service.ParkingLotService;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import java.util.function.Predicate;

public class ParkingLotServiceImpl implements ParkingLotService {
  @Autowired
  private EntityManager entityManager;

  @Autowired
  private ParkingLot parkingLot;


  @Override
  public QueryResults<ParkingLotDto> findParkingLots(Predicate predicate, Pageable pageable) {
    JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
    return null;
  }
}
