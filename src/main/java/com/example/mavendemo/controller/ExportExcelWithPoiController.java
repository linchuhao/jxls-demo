package com.example.mavendemo.controller;

import com.example.mavendemo.dto.ParkingLotExportObject;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/excelWithPoi")
public class ExportExcelWithPoiController {

  private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");

  @GetMapping("/exportExcel")
  public void downloadExcel(HttpServletResponse response) throws Exception {
    List<ParkingLotExportObject> parkingLotExportObject = new ArrayList<>();
    parkingLotExportObject.add(new ParkingLotExportObject(1, "parkingLotName1", "address1", 22, 5));
    parkingLotExportObject.add(new ParkingLotExportObject(2, "parkingLotName2", "address2", 3, 5));
    parkingLotExportObject.add(new ParkingLotExportObject(3, "parkingLotName3", "address3", 2, 4));
    parkingLotExportObject.add(new ParkingLotExportObject(4, "parkingLotName4", "address4", 5, 5));
    parkingLotExportObject.add(new ParkingLotExportObject(5, "parkingLotName5", "address5", 5, 5));
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    generateOutputExcel(parkingLotExportObject).write(os);
    byte[] content = os.toByteArray();
    InputStream is = new ByteArrayInputStream(content);
    response.reset();
    response.setContentType("application/vnd.ms-excel;charset=utf-8");
    response.setHeader(
        "Content-Disposition",
        "attachment;filename="
            + new String(
                String.format("SchemaData_%s.xlsx", dateFormatter.format(new Date())).getBytes(),
                StandardCharsets.ISO_8859_1));
    ServletOutputStream out = response.getOutputStream();
    try (BufferedInputStream bis = new BufferedInputStream(is);
        BufferedOutputStream bos = new BufferedOutputStream(out)) {
      byte[] buff = new byte[20480];
      int bytesRead;
      while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
        bos.write(buff, 0, bytesRead);
      }
    }
  }

  private XSSFWorkbook generateOutputExcel(List<ParkingLotExportObject> parkingLotExportObject)
      throws Exception {
    Resource resource = new ClassPathResource("template/parking_lot_info_with_poi.xlsx");
    InputStream inputStream = resource.getInputStream();
    XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
    XSSFSheet sheet = workbook.getSheet("Sheet1");
    Date createTime = new Date();
    String formatCreateTime = dateFormatter.format(createTime);
    generateExcelRowData(parkingLotExportObject, sheet, formatCreateTime);
    return workbook;
  }

  private void generateExcelRowData(
      List<ParkingLotExportObject> parkingLotExportObjects,
      XSSFSheet sheet,
      String formatCreateTime) {
    int index = 3;
    XSSFRow bodyRow;
    bodyRow = sheet.getRow(1);
    bodyRow.createCell(1).setCellValue("Lester");
    bodyRow.createCell(3).setCellValue(formatCreateTime);
    for (ParkingLotExportObject parkingLotExportObject : parkingLotExportObjects) {
      bodyRow = sheet.createRow(index++);
      bodyRow.createCell(0).setCellValue(parkingLotExportObject.getId());
      bodyRow.createCell(bodyRow.getLastCellNum()).setCellValue(parkingLotExportObject.getName());
      bodyRow
          .createCell(bodyRow.getLastCellNum())
          .setCellValue(parkingLotExportObject.getAddress());
      bodyRow
          .createCell(bodyRow.getLastCellNum())
          .setCellValue(parkingLotExportObject.getParkingSpaceCapacity());
      bodyRow
          .createCell(bodyRow.getLastCellNum())
          .setCellValue(parkingLotExportObject.getParkingSpaceRemainder());
    }
  }
}
