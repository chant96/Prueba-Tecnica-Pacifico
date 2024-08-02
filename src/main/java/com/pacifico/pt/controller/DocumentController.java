package com.pacifico.pt.controller;

import java.util.List;
import java.util.Objects;

import com.pacifico.pt.model.entity.Document;
import com.pacifico.pt.service.DocumentoService;
import com.pacifico.pt.utils.DocumentConstant;
import com.pacifico.pt.utils.DocumentUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
  private DocumentoService documentService;

  @PostMapping("/upload/excel")
  public ResponseEntity<String> uploadExcelFile(@RequestParam(name = "excelFile") final MultipartFile file) {
    if (!Objects.equals(file.getContentType(), DocumentConstant.EXCEL_TYPE)) {
      return ResponseEntity.badRequest().body("Archivo tipo excel no encontrado");
    }
    documentService.save(DocumentUtils.uploadDocument(file));

    return ResponseEntity.ok("Archivo Excel subido y datos guardados.");
  }

  @PostMapping("/upload/pdf")
  public ResponseEntity<String> uploadPdfFile(@RequestParam("pdfFile") final MultipartFile file) {
    if (!Objects.equals(file.getContentType(),DocumentConstant.PDF_TYPE)) {
      return ResponseEntity.badRequest().body("Archivo tipo pdf no encontrado");
    }
    documentService.save(DocumentUtils.uploadDocument(file));

    return ResponseEntity.ok("Archivo Pdf subido y datos guardados.");
  }

    @GetMapping("/documents")
    public ResponseEntity<List<Document>> getDocuments() {
      final List<Document> documents = documentService.findAll();
      return ResponseEntity.ok(documents);
    }
}
