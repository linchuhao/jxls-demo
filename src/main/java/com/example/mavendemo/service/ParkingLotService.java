package com.example.mavendemo.service;

import com.example.mavendemo.dto.parkingLotDto;
import com.example.mavendemo.entity.ParkingLot;
import com.querydsl.core.QueryResults;
import org.springframework.data.domain.Pageable;
import java.util.function.Predicate;

public interface ParkingLotService {
  QueryResults<parkingLotDto> findParkingLots(Predicate predicate, Pageable pageable);
}
