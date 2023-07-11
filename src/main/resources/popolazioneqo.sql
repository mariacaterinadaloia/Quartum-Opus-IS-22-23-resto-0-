/*popolazione*/
/*avviare dopo aver avviato quartumopus.sql
create table utente(
	mail varchar(256) not null, 
    password varchar(45) not null, 
    nome varchar(45) not null, 
    cognome varchar(60) not null, 
    datadinascita date not null, 
    gestore bool default false, 
    primary key(mail)
    ); */
use quartumopus;

insert into utente values ('catedal@gmail.com', 'machitsap', 'Kate', 'Dal', 20010706, true);
insert into utente values ('framon@gmail.com', 'hetconlamama', 'Francies',  'Monets', 20010505 , true);
insert into utente values ('manuilmagnifico@hotmail.com', 'Magnifique!3', 'Manuel', 'Sicà', 20010526, false);
insert into utente values('ludssss@gmail.com', 'ZLmylife', 'Ludo', 'Genovens', 20010716, false);

/*create table ordine(
	id int not null auto_increment, 
    data date not null, 
    utente varchar(256) not null, 
    primary key(id), 
    foreign key(utente) references utente(mail)
);*/

insert into ordine values (1, 20200228, 'ludssss@gmail.com');
insert into ordine values (2, 20200304, 'manuilmagnifico@hotmail.com');
insert into ordine values (3, 20220109, 'ludssss@gmail.com');
/*
create table autore(
	nome varchar(45) not null, 
    cognome varchar(60) not null, 
    codice varchar(16) not null, 
    datanascita date not null, 
    primary key(codice)
);
*/

insert into autore values ('Julia', 'Queen', '934723', 19901230);
insert into autore values ('Andrea', 'Queen', '956723', 19901230);
insert into autore values ('Nova', 'Queen', '934423', 19901230);
insert into autore values ('George', 'Orwell', '945687', 19541012);
insert into autore values ('Andrea', 'Iannone', '998764', 19860203);
insert into autore values ('Francesca', 'Bianchi', '854964', 19920506);
insert into autore values ('James' , 'Smith', '958796', 19761012);
/*
create table prodotto(
	ISBN bigint not null,
    nome varchar(512) not null,
    genere varchar(32) not null,
    anno int not null,
    edizione int not null,
    casa_editrice varchar(128) not null,
    copertina varchar(512),
    primary key(ISBN)
); */

insert into prodotto values (93764321, '1984',  'romanzo', 1948, 3, 'Einaudi', 'https://www.lafeltrinelli.it/images/9788807903816_0_536_0_75.jpg', 10, true, "https://drive.google.com/uc?id=1TDtb8CcdpG_9Xcdv-W2bnOCKCqRTo7Ze&export=download");
insert into prodotto values (98483645, 'Circe', 'thriller', 2008, 4, 'Feltrinelli', 'https://www.lafeltrinelli.it/images/9788829705320_0_536_0_75.jpg', 14, true, "https://drive.google.com/uc?id=10aRk9_APBCBN0bEkszbrV5DKOuEUxv7k&export=download");
insert into prodotto values (2844872, 'Le sette regole per avere successo', 'educazione', 2011, 1,  'Mondadori', 'https://www.lafeltrinelli.it/images/9788835117797_0_536_0_75.jpg', 9, true, "https://drive.google.com/uc?id=1TDtb8CcdpG_9Xcdv-W2bnOCKCqRTo7Ze&export=download");
insert into prodotto values (9658452, "Conosci l'estate", 'giallo', 2002, 4, 'Sellerio', 'https://www.lafeltrinelli.it/images/9788838940590_0_536_0_75.jpg', 12, true, "https://drive.google.com/uc?id=1KjBRZ4BmBAVGs619_CMlJEnLDwQTEsG_&export=download");
insert into prodotto values (9458628, "Object Oriented Software Engineering", 'thriller', 1999, 3, 'Einaudi', 'https://m.media-amazon.com/images/I/51jNe4y1+-L._SX362_BO1,204,203,200_.jpg', 25, true, 'https://drive.google.com/uc?id=13BsxvOzaxxHAgfwWLUciQi8Q2rvW2EA7&export=download');
/*

create table scritto_da(
	prodotto bigint not null,
    autore varchar(16) not null,
    foreign key(autore) references autore(codice),
    foreign key(prodotto) references prodotto(ISBN)
);
*/

insert into scritto_da values (93764321, '945687');
insert into scritto_da values (98483645, '956723');
insert into scritto_da values (2844872, '934423');
insert into scritto_da values (9658452, '854964');
insert into scritto_da values (9458628, '958796');

/*
create table contiene(
	ordine int not null,
    foreign key(ordine) references ordine(id),
    prodotto bigint not null,
	foreign key(prodotto) references prodotto(ISBN)
);*/

insert into contiene values (1,93764321);
insert into contiene values (1, 98483645);
insert into contiene values (2, 98483645);
insert into contiene values (2, 9458628);
insert into contiene values (3, 98483645);
insert into contiene values (3, 9658452);
/*create table  recensione(
    utente varchar(256) not null,
    foreign key(utente) references utente(mail),
    prodotto bigint not null,
    foreign key(prodotto) references prodotto(ISBN),
    text varchar(1024) not null
); */
insert into recensione values (1, 'Bel libro');
insert into recensione values (2, 'Bel libro, lo consiglio');
insert into recensione values(3, 'Ottimo libro! consigliato');
insert into recensione values(4, 'Lo consiglio a chi è appassionato del genere');
insert into recensione values(5, 'Libro perfetto. Lo consiglio a tutti');

insert into recDi values (2844872, 1);
insert into recDi values (98483645, 2);
insert into recDi values (93764321, 3);
insert into recDi values (9658452, 4);
insert into recDi values (9458628, 5);

insert into recDa values ('catedal@gmail.com', 1);
insert into recDa values ('catedal@gmail.com', 2);
insert into recDa values ('manuilmagnifico@hotmail.com', 3);
insert into recDa values ('ludssss@gmail.com', 4);
insert into recDa values ('framon@gmail.com', 5);