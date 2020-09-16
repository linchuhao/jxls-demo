package com.example.mavendemo.service.impl;

import com.example.mavendemo.dto.ParkingLotDto;
import com.example.mavendemo.service.ExcelHandleService;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.example.mavendemo.util.ExcelUtils.parseExcel;

@Service
public class ExcelHandleServiceImpl implements ExcelHandleService {

  @Override
  public String uploadExcel(MultipartFile multipartFile) throws Exception {
    XSSFWorkbook workbook = new XSSFWorkbook(multipartFile.getInputStream());
    List<ParkingLotDto> parkingLots = parseExcel(workbook);
    for (ParkingLotDto parkingLot : parkingLots) {
      System.out.println(parkingLot.getParkingLotId());
      System.out.println(parkingLot.getParkingLotName());
      System.out.println(parkingLot.getAddress());
      System.out.println(parkingLot.getCapacity());
      System.out.println(parkingLot.getRemainder());
    }
    return "test";
  }
}
