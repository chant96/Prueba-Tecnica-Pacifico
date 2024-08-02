package com.pacifico.pt.service;

import java.util.List;

import com.pacifico.pt.model.dao.DocumentDao;
import com.pacifico.pt.model.entity.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentServiceImpl implements DocumentService {

  @Autowired
  private DocumentDao documentDao;

  @Override
  public void save(final Document document) {
    documentDao.save(document);
  }

  @Override
  public List<Document> findAll() {
    return documentDao.findAll();
  }
}
