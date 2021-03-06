DROP TABLE IF EXISTS parking_lot;
DROP TABLE IF EXISTS parking_lot_space;
CREATE TABLE parking_lot (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(200) NOT NULL,
  address VARCHAR(200) NOT NULL,
  parking_space_capacity INT NOT NULL,
  parking_space_remainder INT NOT NULL
);
CREATE TABLE parking_lot_space (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  parking_lot_id INT NOT NULL,
  price INT NOT NULL
);
INSERT INTO parking_lot (name, address, parking_space_capacity, parking_space_remainder) VALUES
 ('South Software Parking Lot','广东省珠海市香洲区软件园路1号',20,15),
 ('South Technology Parking Lot','广东省珠海市高新区科技园路2号',40,10),
 ('Gree Coast Parking Lot','广东省珠海市香洲区情侣北路3333号',200,115),
 ('TECH 2 BAY Parking Lot','广东省珠海市香洲区唐中路港湾2号科创园',80,10),
 ('North Software Parking Lot','广东省珠海市金湾区软件园路1号',50,15),
 ('Eastern Technology Parking Lot','广东省珠海市高新区科技园路6号',80,10),
 ('South Technology Parking Lot','广东省珠海市高新区科技园路2号',40,10),
 ('Java Coast Parking Lot','广东省珠海市香洲区情侣北路5555号',200,115),
 ('TECH 3 BAY Parking Lot','广东省珠海市香洲区唐中路港湾3号科创园',80,10),
 ('North Software Parking Lot','广东省珠海市金湾区软件园路12号',50,15),
 ('North Technology Parking Lot','广东省珠海市高新区科技园路66号',80,10),
 ('Free east Parking Lot','广东省珠海市香洲区情侣南路2222号',100,15);
 INSERT INTO parking_lot_space (parking_lot_id, price) VALUES
 (1,15),
 (1,10),
 (1,15),
 (1,10),
 (2,15),
 (2,10),
 (2,15),
 (2,15),
 (2,10),
 (3,15),
 (3,10);