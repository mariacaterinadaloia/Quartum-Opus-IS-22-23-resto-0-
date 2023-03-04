package gestore.model;

import generic.Bean;

public class ScrittoDaBean implements Bean {
    private long prodotto;
    private String autore;

    public ScrittoDaBean() {}

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public long getProdotto() {
        return prodotto;
    }

    public void setProdotto(long prodotto) {
        this.prodotto = prodotto;
    }
}
