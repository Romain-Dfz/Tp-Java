CREATE TABLE lieu (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    adresse VARCHAR(255) NOT NULL,
    capacite INT
);

CREATE TABLE evenement (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    date DATE NOT NULL,
    heure VARCHAR(255) NOT NULL,
    prix FLOAT NOT NULL,
    lieu_id INT,
    FOREIGN KEY (lieu_id) REFERENCES lieu(id)
);

CREATE TABLE client (
    nom VARCHAR(255) NOT NULL,
    prenom VARCHAR(255) NOT NULL,
    email VARCHAR(255) PRIMARY KEY
);

CREATE TABLE billet (
    client_email VARCHAR(255),
    evenement_id INT,
    PRIMARY KEY (client_email, evenement_id),
    FOREIGN KEY (client_email) REFERENCES client(email),
    FOREIGN KEY (evenement_id) REFERENCES evenement(id)
);


