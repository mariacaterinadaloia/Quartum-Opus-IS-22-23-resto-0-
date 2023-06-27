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

insert into prodotto values (93764321, 'I tuoi occhi mi parlano...',  'romanzo', 2020, 3, 'Einadi', 'StringCopertina', 10, true);
insert into prodotto values (98483645, '.., e mi dicono...', 'thriller', 2008, 4, 'Feltrinelli', 'String', 14, true);
insert into prodotto values (2844872, '...hai paura di IS', 'giallo', 2011, 1,  'Mondadori', 'strgg', 9, false);
/*

create table scritto_da(
	prodotto bigint not null, 
    autore varchar(16) not null, 
    foreign key(autore) references autore(codice), 
    foreign key(prodotto) references prodotto(ISBN)
);
*/

insert into scritto_da values (93764321, '934723');
insert into scritto_da values (98483645, '956723'); 
insert into scritto_da values (2844872, '934423');

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
insert into contiene values (3, 98483645);
/*create table  recensione(
    utente varchar(256) not null,
    foreign key(utente) references utente(mail),
    prodotto bigint not null,
    foreign key(prodotto) references prodotto(ISBN),
    text varchar(1024) not null
); */
insert into recensione values (100, 'bel libro');
insert into recensione values (111, 'bel libro');

insert into recDi values (100,2844872);
insert into recDi values (111,98483645);

insert into recDa values (100,'catedal@gmail.com');
insert into recDa values (111,'catedal@gmail.com');