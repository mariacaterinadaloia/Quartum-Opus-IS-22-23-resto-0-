package utente.model;

import generic.Bean;

public class ContieneBean implements Bean {
    private int ordine;
    private long prodotto;

    public ContieneBean() {}

    public int getOrdine() {
        return ordine;
    }

    public void setOrdine(int ordine) {
        this.ordine = ordine;
    }

    public long getProdotto() {
        return prodotto;
    }

    public void setProdotto(long prodotto) {
        this.prodotto = prodotto;
    }
}
