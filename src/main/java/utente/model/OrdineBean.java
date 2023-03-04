package utente.model;

import generic.Bean;

import java.util.Date;

public class OrdineBean implements Bean {
    private int id;
    private Date data;
    private String utente;

    public OrdineBean(){};

    public String getUtente() {
        return utente;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
