create database gestion_biblio_minisas;
USE gestion_biblio_minisas;

create Table auteurs(
	id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    email varchar(255)
);
create Table bibliotecaires(
	id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    email varchar(255)
);

create table livres(
id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    num_isbn varchar(255),
    title varchar(255),
    qteTotal int,
    qtePerdu int,
    qteEmprunte int,
    qteDisponible int,
    auteur_id int,
    bibliotecaire_id int,
    FOREIGN KEY (auteur_id) REFERENCES  auteurs(id) on UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (bibliotecaire_id) REFERENCES  bibliotecaires(id) on UPDATE CASCADE ON DELETE CASCADE
);
create table emprunteurs(
id int primary key AUTO_INCREMENT NOT NULL,
    name varchar(255) ,
    email varchar(255),
    cin varchar(255)
);
create table emprunte(
id int primary key AUTO_INCREMENT NOT NULL,
 livre_id int,
 emprunteur_id int,
    date_demprunt date,
    date_retour date,
    qte int ,
    FOREIGN KEY (livre_id) REFERENCES  livres(id) on UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (emprunteur_id) REFERENCES  emprunteurs(id) on UPDATE CASCADE ON DELETE CASCADE
);

//trigger
 DELIMITER //
CREATE TRIGGER livreEmpruntes
AFTER INSERT ON emprunte
FOR EACH ROW
BEGIN
UPDATE livres SET qteemprunte=qteemprunte + NEW.qte
WHERE id=NEW.livre_id;
END ;
// DELIMITER
 ;