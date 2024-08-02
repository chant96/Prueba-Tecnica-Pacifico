package com.pacifico.pt.service;

import java.util.List;

import com.pacifico.pt.model.dao.DocumentDao;
import com.pacifico.pt.model.entity.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentServiceImpl implements DocumentoService {

  @Autowired
  private DocumentDao documentDao;

  @Override
  public Document save(Document document) {
    return documentDao.save(document);
  }

  @Override
  public List<Document> findAll() {
    return documentDao.findAll();
  }
}
