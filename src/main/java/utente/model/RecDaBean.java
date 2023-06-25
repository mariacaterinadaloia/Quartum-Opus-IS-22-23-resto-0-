package utente.model;

import generic.Bean;

public class RecDaBean implements Bean {
    private String utente;
    private int recensione;

    public RecDaBean() {
    }

    public String getUtente() {
        return utente;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }

    public int getRecensione() {
        return recensione;
    }

    public void setRecensione(int recensione) {
        this.recensione = recensione;
    }
}
