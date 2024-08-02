package com.pacifico.pt.utils;

import java.util.Date;
import java.util.Objects;

import com.pacifico.pt.model.entity.Document;
import com.pacifico.pt.model.entity.DocumentData;
import com.pacifico.pt.service.DocumentDataService;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DocumentUtils {

  /**
   * Method to separate the name and extension of a file.
   *
   * @param fullFileName the complete file name.
   * @return An array of two elements.
   */
  public static String[] separateByFileNameAndExtension(final String fullFileName) {
    int indexSeparator = fullFileName.lastIndexOf('.');

    final String fileName = fullFileName.substring(0, indexSeparator);
    final String fileExtension = fullFileName.substring(indexSeparator + 1);
    return new String[]{fileName, fileExtension};
  }

  /**
   * Method to obtain the properties of an uploaded file.
   *
   * @param file the file.
   * @return The uploaded file properties.
   */
  public static Document getPropertiesFromFile(final MultipartFile file) {
    final String fileName = separateByFileNameAndExtension(Objects.requireNonNull(file.getOriginalFilename()))[0];
    final String fileExtension = separateByFileNameAndExtension(Objects.requireNonNull(file.getOriginalFilename()))[1];
    final Document document = new Document();
    document.setFileName(fileName);
    document.setFileExtension(fileExtension);
    document.setUploadDate(new Date());
    document.setFileSize(String.valueOf(file.getSize()));
    return document;
  }

  /**
   * Method to process an Excel file and save the document data.
   *
   * @param book The current book of Excel.
   * @param documentDataService The service of the DocumentData.
   */
  public static void processExcelFile(final Workbook book, final DocumentDataService documentDataService) {
    for (final Row row : book.getSheetAt(0)) {
      if (row.getRowNum() == 0) {
        continue;
      }
      final DocumentData documentData = new DocumentData();
      documentData.setRowName(row.getCell(1).getStringCellValue());
      documentData.setRowAge((int) row.getCell(2).getNumericCellValue());
      documentData.setRowEmail(row.getCell(3).getStringCellValue());
      documentDataService.save(documentData);
    }
  }
}
