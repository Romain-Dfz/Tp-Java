CREATE DATABASE universite;

CREATE TABLE etudiant (
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nom VARCHAR(255),
    prenom VARCHAR(255),
    classe VARCHAR(50),
    date_diplome DATE
);

SELECT * FROM etudiant;

DELETE FROM etudiant WHERE id = 6;