package com.pacifico.pt.service;

import com.pacifico.pt.model.dao.DocumentDataDao;
import com.pacifico.pt.model.entity.DocumentData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentDataServiceImpl implements DocumentDataService {

  @Autowired
  public DocumentDataDao documentDataDao;

  @Override
  public void save(final DocumentData documentData) {
    documentDataDao.save(documentData);
  }
}
