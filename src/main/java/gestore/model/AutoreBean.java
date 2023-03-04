package gestore.model;

import generic.Bean;

import java.util.Date;

public class AutoreBean implements Bean {
    private String nome;
    private String cognome;
    private String codice;
    private Date datanascita;

    public AutoreBean(){};

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDatanascita() {
        return datanascita;
    }

    public void setDatanascita(Date datanascita) {
        this.datanascita = datanascita;
    }
}
