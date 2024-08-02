package com.pacifico.pt.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DocumentConstant {

  public static final String EXCEL_TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

  public static final String PDF_TYPE = "application/pdf";

  public static final String EXCEL_FILE_NOT_FOUND_MESSAGE =
      "¡Archivo incorrecto o no se ha cargado!. Solo se permite cargar archivos tipo Excel.";

  public static final String PDF_FILE_NOT_FOUND_MESSAGE =
      "¡Archivo incorrecto o no se ha cargado!. Solo se permite cargar archivos tipo PDF.";

  public static final String UPLOADED_EXCEL_DOCUMENT_MESSAGE = "Archivo Excel subido y datos guardados.";

  public static final String UPLOADED_PDF_DOCUMENT_MESSAGE = "Archivo Excel subido y datos guardados.";
}
