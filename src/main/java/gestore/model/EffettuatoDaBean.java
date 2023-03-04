package gestore.model;

import generic.Bean;

public class EffettuatoDaBean implements Bean {
    private int ordine;
    private String utente;

    public EffettuatoDaBean() {
    }

    public String getUtente() {
        return utente;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }

    public int getOrdine() {
        return ordine;
    }

    public void setOrdine(int ordine) {
        this.ordine = ordine;
    }
}
