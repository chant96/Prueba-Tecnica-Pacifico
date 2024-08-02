CREATE DATABASE PruebaTecnicaDB;

USE PruebaTecnicaDB;

CREATE TABLE Document (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fileName VARCHAR(255) NOT NULL,
    fileExtension VARCHAR(255) NOT NULL,
    uploadDate TIMESTAMP NOT NULL,
    fileSize BIGINT NOT NULL
);

CREATE TABLE DocumentData (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    rowAge INT,
    rowEmail VARCHAR(100),
    rowName VARCHAR(100)
);

SELECT * FROM Document;
SELECT * FROM DocumentData;
