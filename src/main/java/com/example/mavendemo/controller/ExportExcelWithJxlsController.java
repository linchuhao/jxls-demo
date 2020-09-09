package com.example.mavendemo.controller;

import com.example.mavendemo.dto.ParkingLotExportObject;
import com.example.mavendemo.utils.JxlsUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/excelWithJxls")
public class ExportExcelWithJxlsController {

  @GetMapping("/exportExcel")
  public void listExport(HttpServletResponse response, HttpServletRequest request)
      throws Exception {

    String filename = "parking_lot_ex.xlsx";
    List<ParkingLotExportObject> parkingLotExportObject = new ArrayList<>();
    parkingLotExportObject.add(new ParkingLotExportObject(1, "parkingLotName1", "address1", 22, 5));
    parkingLotExportObject.add(new ParkingLotExportObject(2, "parkingLotName2", "address2", 3, 5));
    parkingLotExportObject.add(new ParkingLotExportObject(3, "parkingLotName3", "address3", 2, 4));
    parkingLotExportObject.add(new ParkingLotExportObject(4, "parkingLotName4", "address4", 5, 5));
    parkingLotExportObject.add(new ParkingLotExportObject(5, "parkingLotName5", "address5", 5, 5));

    HashMap<String, Object> model = new HashMap<>(16);
    model.put("parkingLots", parkingLotExportObject);

    JxlsUtils.exportExcel("parking_lot_info.xlsx", model, response, request, filename);
  }
}
