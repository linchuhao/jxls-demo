package com.example.mavendemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "parking_lot_space")
public class ParkingLotSpace {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private int parkingLotId;
  private int price;
}
