package com.example.mavendemo.controller;

import com.example.mavendemo.service.ExcelHandleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController("/uploadExcelWithPoi")
@ResponseBody
public class UploadExcelWithPoiController {


  @Resource
  ExcelHandleService excelHandleService;

  @PostMapping
  public String uploadExcelWithPoi(@RequestParam MultipartFile file) throws Exception{
    return excelHandleService.uploadExcel(file);
  }
}
