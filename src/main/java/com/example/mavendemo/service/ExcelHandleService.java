package com.example.mavendemo.service;

import org.springframework.web.multipart.MultipartFile;

public interface ExcelHandleService {
  String uploadExcel(MultipartFile multipartFile) throws Exception;
}
