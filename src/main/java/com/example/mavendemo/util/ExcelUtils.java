package com.example.mavendemo.util;

import com.example.mavendemo.dto.ParkingLotDto;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {

  public static List<ParkingLotDto> parseExcel(XSSFWorkbook workbook) {
    List<ParkingLotDto> parkingLotDtos = new ArrayList<>();
    XSSFSheet sheet = workbook.getSheet("parkingLotsSheet");
    for (int rowNum = 3; rowNum <= sheet.getPhysicalNumberOfRows(); rowNum++) {
      XSSFRow row = sheet.getRow(rowNum);
      if (null == row.getCell(0).getRawValue()) {
        break;
      }
      ParkingLotDto parkingLotDto = convertRowToSchema(row);
      parkingLotDtos.add(parkingLotDto);
    }
    return parkingLotDtos;
  }

  public static ParkingLotDto convertRowToSchema(XSSFRow row) {
    ParkingLotDto parkingLot = null;
    if (!StringUtils.isEmpty(row.getCell(0))
        && !StringUtils.isEmpty(row.getCell(1))
        && !StringUtils.isEmpty(row.getCell(2))
        && !StringUtils.isEmpty(row.getCell(3))
        && !StringUtils.isEmpty(row.getCell(4))) {
      parkingLot =
          ParkingLotDto.builder()
              .parkingLotId((int) (row.getCell(0).getNumericCellValue()))
              .parkingLotName(row.getCell(1).getStringCellValue())
              .address(row.getCell(2).getStringCellValue())
              .capacity((int)(row.getCell(3).getNumericCellValue()))
              .Remainder((int)(row.getCell(4).getNumericCellValue()))
              .build();
    }
    return parkingLot;
  }
}
