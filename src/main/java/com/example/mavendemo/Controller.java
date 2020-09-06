package com.example.mavendemo;

import com.example.mavendemo.dto.ParkingLotExportObject;
import com.example.mavendemo.utils.JxlsUtils;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.jxls.common.Context;
import org.jxls.transform.poi.PoiContext;
import org.jxls.util.JxlsHelper;

@RestController
@RequestMapping("/parkingLots")
public class Controller {
  @GetMapping
  public String hello() {
    return "hello";
  }
}
