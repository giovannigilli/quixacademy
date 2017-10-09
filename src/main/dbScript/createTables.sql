CREATE TABLE soggetti (
	username varchar(50) NOT NULL PRIMARY KEY,
	email varchar(50) NOT NULL,
	ragione_sociale varchar(255),
	nome varchar(50),
	cognome varchar(50),
	immagine varchar(255),
	data_ultima_modifica datetime
);

CREATE TABLE oggetti (
	id int NOT NULL PRIMARY KEY,
	proprietario varchar(50) NOT NULL,
	titolo varchar(255),
	descrizione text,
	immagine varchar(255),
	categoria varchar(255),
	data_ultima_modifica datetime,
	CONSTRAINT fk_oggetti_soggetti FOREIGN KEY (proprietario) REFERENCES soggetti(username)
);

CREATE TABLE prestiti (
	beneficiario varchar(50) NOT NULL,
	oggetto_prestato int NOT NULL,
	data_prestito datetime,
	data_scadenza_prestito datetime,
	PRIMARY KEY (beneficiario, oggetto_prestato),
	CONSTRAINT fk_prestiti_soggetti FOREIGN KEY (beneficiario) REFERENCES soggetti(username),
	CONSTRAINT fk_prestiti_oggetti FOREIGN KEY (oggetto_prestato) REFERENCES oggetti(id)
);