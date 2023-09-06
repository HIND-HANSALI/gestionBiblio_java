create Table acteurs(
id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    email varchar(255)
)
create table livres(
id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    title varchar(255),
    num_isbn varchar(255),
    qtetotal int,
    qteperdu int,
    qteemprunte int,
    statut varchar(255),
    auteur_id int,
    FOREIGN KEY (auteur_id) REFERENCES  auteurs(id) on UPDATE CASCADE ON DELETE CASCADE
)
