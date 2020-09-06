package com.example.mavendemo.dto;

import lombok.Data;

@Data
public class ParkingLotExportObject {

  private int id;

  private String name;

  private String address;

  private int parkingSpaceCapacity;

  private int parkingSpaceRemainder;

  public ParkingLotExportObject(int id, String name, String address, int parkingSpaceCapacity,
      int parkingSpaceRemainder) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.parkingSpaceCapacity = parkingSpaceCapacity;
    this.parkingSpaceRemainder = parkingSpaceRemainder;
  }
}
