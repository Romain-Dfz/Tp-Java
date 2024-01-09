USE produits;

CREATE TABLE produits (
    id INT AUTO_INCREMENT PRIMARY KEY,
    marque VARCHAR(255),
    reference VARCHAR(255),
    date_achat DATE,
    prix DOUBLE,
    stock INT
);
