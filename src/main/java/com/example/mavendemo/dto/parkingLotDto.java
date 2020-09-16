package com.example.mavendemo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ParkingLotDto {
  private int parkingLotId;
  private String parkingLotName;
  private String address;
  private int capacity;
  private int Remainder;
}
