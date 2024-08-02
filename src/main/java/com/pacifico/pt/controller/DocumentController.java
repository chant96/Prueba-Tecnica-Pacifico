package com.pacifico.pt.controller;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import com.pacifico.pt.model.entity.Document;
import com.pacifico.pt.service.DocumentDataService;
import com.pacifico.pt.service.DocumentService;
import com.pacifico.pt.utils.DocumentConstant;
import com.pacifico.pt.utils.DocumentUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class DocumentController {

  @Autowired
  private DocumentService documentService;

  @Autowired
  private DocumentDataService documentDataService;

  @PostMapping("/upload/excel")
  public ResponseEntity<String> uploadExcelFile(@RequestParam(name = "excelFile") final MultipartFile file) throws IOException {
    if (!Objects.equals(file.getContentType(), DocumentConstant.EXCEL_TYPE)) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(DocumentConstant.EXCEL_FILE_NOT_FOUND_MESSAGE);
    }
    try (final Workbook book = new XSSFWorkbook(file.getInputStream())) {
      DocumentUtils.processExcelFile(book, documentDataService);
      documentService.save(DocumentUtils.getPropertiesFromFile(file));
    }
    return ResponseEntity.ok(DocumentConstant.UPLOADED_EXCEL_DOCUMENT_MESSAGE);
  }

  @PostMapping("/upload/pdf")
  public ResponseEntity<String> uploadPdfFile(@RequestParam("pdfFile") final MultipartFile file) {
    if (!Objects.equals(file.getContentType(), DocumentConstant.PDF_TYPE)) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(DocumentConstant.PDF_FILE_NOT_FOUND_MESSAGE);
    }
    documentService.save(DocumentUtils.getPropertiesFromFile(file));

    return ResponseEntity.ok(DocumentConstant.UPLOADED_PDF_DOCUMENT_MESSAGE);
  }

  @GetMapping("/documents")
  public ResponseEntity<List<Document>> getDocuments() {
    final List<Document> documents = documentService.findAll();
    if (documents.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.ok(documents);
  }
}
