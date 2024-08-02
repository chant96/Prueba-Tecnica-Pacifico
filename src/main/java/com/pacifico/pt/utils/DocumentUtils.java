package com.pacifico.pt.utils;

import java.util.Date;
import java.util.Objects;

import com.pacifico.pt.model.entity.Document;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
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
   * Method to upload a document from an uploaded file.
   *
   * @param file the file type.
   * @return The document with the file properties.
   */
  public static Document uploadDocument(final MultipartFile file) {
    final String fileName = separateByFileNameAndExtension(Objects.requireNonNull(file.getOriginalFilename()))[0];
    final String fileExtension = separateByFileNameAndExtension(Objects.requireNonNull(file.getOriginalFilename()))[1];

    final Document document = new Document();
    document.setFileName(fileName);
    document.setFileExtension(fileExtension);
    document.setUploadDate(new Date());
    document.setFileSize(String.valueOf(file.getSize()));
    return document;
  }
}
