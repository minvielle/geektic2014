DROP TABLE Liaison_Geek_Interet;
DROP TABLE Consultation;
DROP TABLE Geek;
DROP TABLE Interet;

CREATE TABLE Geek
(
num integer PRIMARY KEY IDENTITY,
nom varchar(20) NOT NULL,
prenom varchar(20) NOT NULL,
sexe varchar(1) NOT NULL,
age integer,
url_gravatar varchar(150),
CONSTRAINT geek_sexe_chk CHECK(sexe in ('F', 'M'))
);

CREATE TABLE Interet
(
num integer PRIMARY KEY IDENTITY,
nom varchar(20) NOT NULL
);

CREATE TABLE Liaison_Geek_Interet
(
numG integer,
numI integer,
PRIMARY KEY (numG, numI),
FOREIGN KEY (numG) REFERENCES Geek(num),
FOREIGN KEY (numI) REFERENCES Interet(num)
);

CREATE TABLE Consultation
(
numG integer,
date date,
heure time,
ip varchar(30),
PRIMARY KEY (numG, date, heure),
FOREIGN KEY (numG) REFERENCES Geek(num)
);