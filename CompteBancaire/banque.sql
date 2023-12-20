CREATE DATABASE IF NOT EXISTS banque;
USE banque;

CREATE TABLE IF NOT EXISTS client (
    identifiant VARCHAR(50) PRIMARY KEY,
    nom VARCHAR(50),
    prenom VARCHAR(50),
    numeroTelephone VARCHAR(15)
);

CREATE TABLE IF NOT EXISTS compte_bancaire (
    id INT AUTO_INCREMENT PRIMARY KEY,
    solde DOUBLE,
    client_identifiant VARCHAR(50),
    FOREIGN KEY (client_identifiant) REFERENCES client(identifiant)
);

CREATE TABLE IF NOT EXISTS operation (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numero INT,
    montant DOUBLE,
    statut ENUM('DEPOT', 'RETRAIT'),
    compte_bancaire_id INT,
    FOREIGN KEY (compte_bancaire_id) REFERENCES compte_bancaire(id)
);

SELECT * FROM banque;

