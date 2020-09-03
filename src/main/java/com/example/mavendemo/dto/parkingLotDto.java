package com.example.mavendemo.dto;

import lombok.Data;

@Data
public class parkingLotDto {
  private int parkingLotId;
  private String parkingLotName;
  private int parkingLotSpaceId;
  private int price;
}
