package org.skypro.skyshop.product;

import org.skypro.skyshop.exception.BestResultNotFound;

import java.util.*;

public class SearchEngine {
    private Map<String, Searchable> searchMas;

    public SearchEngine() {
        searchMas = new TreeMap<>();
    }

    public TreeMap<String, Searchable> search(String str) {
        TreeMap<String, Searchable> result = new TreeMap<>();
        Iterator<String> itr = searchMas.keySet().iterator();
        while (itr.hasNext()) {
            Searchable s = searchMas.get(itr.next());
            if (s.getSeachTerm(str).contains(str)) {
                result.put(s.getProductName(), s);
            }
        }
        return result;
    }

    public boolean add(Searchable o) {
        if (o != null) {
            searchMas.put(o.getProductName(), o);
            return true;
        }
        return false;
    }

    //frequency-semantic analysis was used
    public Searchable getBestResult(String search) throws BestResultNotFound {
        int maxWeight = 0;
        Searchable result = null;
        Iterator<String> itr = searchMas.keySet().iterator();
        while (itr.hasNext()) {
            Searchable s = searchMas.get(itr.next());
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
