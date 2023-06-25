package utente.model;

import generic.Bean;

public class RecensioneBean implements Bean{
    /*
    * create table  recensione(
    idRecensione int not null primary key,
    text varchar(1024) not null
    * */

    public RecensioneBean() {
    }

    private int idRecensione;
    private String text;

    public int getIdRecensione() {
        return idRecensione;
    }

    public void setIdRecensione(int recensione) {
        this.idRecensione = recensione;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
