package gestore.model;

import generic.Bean;

import java.util.Objects;

public class ProdottoBean implements Bean {
    private long ISBN;
    private String nome;
    private String genere;
    private int anno;
    private int edizione;
    private String copertina;
    private String casaEditrice;
    private double prezzo;
    private boolean acquistabile;

    public boolean isAcquistabile() {
        return acquistabile;
    }

    public void setAcquistabile(boolean acquistabile) {
        this.acquistabile = acquistabile;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String getCasaEditrice() {
        return casaEditrice;
    }

    public void setCasaEditrice(String casa_editrice) {
        this.casaEditrice = casa_editrice;
    }

    public ProdottoBean(){};

    public String getCopertina() {
        return copertina;
    }

    public void setCopertina(String copertina) {
        this.copertina = copertina;
    }

    public int getEdizione() {
        return edizione;
    }

    public void setEdizione(int edizione) {
        this.edizione = edizione;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdottoBean that = (ProdottoBean) o;
        return ISBN == that.ISBN && anno == that.anno && edizione == that.edizione && Double.compare(that.prezzo, prezzo) == 0 && acquistabile == that.acquistabile && nome.equals(that.nome) && genere.equals(that.genere) && copertina.equals(that.copertina) && casaEditrice.equals(that.casaEditrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ISBN, nome, genere, anno, edizione, copertina, casaEditrice, prezzo, acquistabile);
    }
}
