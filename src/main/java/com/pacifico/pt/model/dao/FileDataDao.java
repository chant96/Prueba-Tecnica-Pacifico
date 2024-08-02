package com.pacifico.pt.model.dao;

import com.pacifico.pt.model.entity.FileData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileDataDao extends JpaRepository<FileData, Long> {

}
