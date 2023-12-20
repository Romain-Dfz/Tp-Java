CREATE DATABASE IF NOT EXISTS banque;
USE banque;

CREATE TABLE compte_bancaire (
    id INT AUTO_INCREMENT PRIMARY KEY,
    solde DECIMAL(10, 2) NOT NULL,
    client_identifiant INT,
    FOREIGN KEY (client_identifiant) REFERENCES client(id)
);

CREATE TABLE client (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255),
    prenom VARCHAR(255)
);

CREATE TABLE operation (
    id INT PRIMARY KEY AUTO_INCREMENT,
    montant DECIMAL(10, 2) NOT NULL,
    type ENUM('DEPOT', 'RETRAIT') NOT NULL,
    compteId INT NOT NULL,
    FOREIGN KEY (compteId) REFERENCES compte_bancaire(id)
);



SELECT * FROM banque;

