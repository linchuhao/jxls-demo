package com.example.mavendemo.service;

import com.example.mavendemo.dto.ParkingLotDto;
import com.querydsl.core.QueryResults;
import org.springframework.data.domain.Pageable;
import java.util.function.Predicate;

public interface ParkingLotService {
  QueryResults<ParkingLotDto> findParkingLots(Predicate predicate, Pageable pageable);
}
