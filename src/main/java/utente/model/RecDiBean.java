package utente.model;

import generic.Bean;

public class RecDiBean implements Bean {
    /*
    * create table recDa(
                      utente varchar(256) not null,
                      foreign key(utente) references utente(mail),
                      recensione int not null,
                      foreign key(recensione) references recensione(idRecensione)
    * */

    private long prodotto;
    private int recensione;

    public RecDiBean() {
    }

    public long getProdotto() {
        return prodotto;
    }

    public void setProdotto(long prodotto) {
        this.prodotto = prodotto;
    }

    public int getRecensione() {
        return recensione;
    }

    public void setRecensione(int recensione) {
        this.recensione = recensione;
    }
}
