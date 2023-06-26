package utente.model;

import java.util.ArrayList;

public class Carrello {
    ArrayList<ProdottoBean> items;

    public Carrello(){
        items = new ArrayList<ProdottoBean>();
    }

    public void addItem(ProdottoBean item){
        if(!items.contains(item)){
            items.add(item);
        }
    }

    public void deleteItem(ProdottoBean item){
        items.remove(item);
    }

    public ArrayList<ProdottoBean> getItems() {
        return items;
    }

    public void deleteAll(){
        items.clear();
    }

    public double getTotal(){
        double totale = 0;
        for (ProdottoBean x: items) {
            totale += x.getPrezzo();
        }
        return totale;
    }
}
