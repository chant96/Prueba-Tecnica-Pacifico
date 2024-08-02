package com.pacifico.pt.model.dao;

import com.pacifico.pt.model.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentDao extends JpaRepository<Document, Long> {

}
