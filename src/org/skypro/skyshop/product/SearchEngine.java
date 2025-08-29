package org.skypro.skyshop.product;

import org.skypro.skyshop.exception.BestResultNotFound;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SearchEngine {
    private List<Searchable> searchMas;

    public SearchEngine() {
        searchMas = new ArrayList<Searchable>();
    }

    public List<Searchable> search(String str) {
        List<Searchable> result = new ArrayList<Searchable>();
        Iterator itr = searchMas.iterator();
        while (itr.hasNext()) {
            Searchable s = (Searchable) itr.next();
            if (s.getSeachTerm(str).contains(str)) {
                result.add(s);
            }
        }
        return result;
    }

    public boolean add(Searchable o) {
        if (o != null) {
            searchMas.add(o);
            return true;
        }
        return false;
    }

    //frequency-semantic analysis was used
    public Searchable getBestResult(String search) throws BestResultNotFound {
        int maxWeight = 0;
        Searchable result = null;
        Iterator<Searchable> itr = searchMas.iterator();
        while(itr.hasNext()) {
            Searchable s = (Searchable) itr.next();
            int weight = s.getSeachTerm(search).split(search, -1).length - 1;
            if (maxWeight <= weight && weight > 0) {
                maxWeight = weight;
                result = s;
            }
        }
        if (result == null) {
            throw new BestResultNotFound("Не нашлось подходящей статьи");
        }
        return result;
    }
}
