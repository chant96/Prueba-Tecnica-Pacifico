package com.pacifico.pt.service;

import java.util.List;

import com.pacifico.pt.model.entity.Document;

public interface DocumentService {

  void save(final Document document);

  List<Document> findAll();
}
