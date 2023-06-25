drop database if exists quartumopus; 

CREATE database quartumopus; 

use quartumopus; 

create table utente(
	mail varchar(256) not null, 
    password varchar(45) not null, 
    nome varchar(45) not null, 
    cognome varchar(60) not null, 
    datadinascita date not null, 
    gestore bool default false, 
    primary key(mail)
    ); 

create table ordine(
	id int not null auto_increment, 
    data date not null, 
    utente varchar(256) not null, 
    primary key(id), 
    foreign key(utente) references utente(mail)
);

create table autore(
	nome varchar(45) not null, 
    cognome varchar(60) not null, 
    codice varchar(16) not null, 
    datanascita date not null, 
    primary key(codice)
);

create table prodotto(
	ISBN bigint not null, 
    nome varchar(512) not null, 
    genere varchar(32) not null, 
    anno int not null, 
    edizione int not null, 
    casa_editrice varchar(128) not null, 
    copertina varchar(512),
    prezzo double not null,
    acquistabile bool not null,
    primary key(ISBN)
); 


create table scritto_da(
	prodotto bigint not null, 
    autore varchar(16) not null, 
    foreign key(autore) references autore(codice), 
    foreign key(prodotto) references prodotto(ISBN)
);

create table contiene(
	ordine int not null, 
    foreign key(ordine) references ordine(id),
    prodotto bigint not null, 
	foreign key(prodotto) references prodotto(ISBN)
);

create table  recensione(
    idRecensione int not null primary key,
    text varchar(1024) not null
);

create table recDa(
                      utente varchar(256) not null,
                      foreign key(utente) references utente(mail),
                      recensione int not null,
                      foreign key(recensione) references recensione(idRecensione)
);

create table recDi(
                      prodotto bigint not null,
                      foreign key(prodotto) references prodotto(ISBN)
                      recensione int not null,
                      foreign key(recensione) references recensione(idRecensione)
);