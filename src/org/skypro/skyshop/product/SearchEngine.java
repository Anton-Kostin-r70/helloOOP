package org.skypro.skyshop.product;

import org.skypro.skyshop.description.Article;
import org.skypro.skyshop.exception.BestResultNotFound;

import java.util.*;

public class SearchEngine {
    private Set<Searchable> searchMas;

    public SearchEngine() {
        searchMas = new HashSet<>();
    }

    public Set<Searchable> search(String str) {
        Set<Searchable> result = new TreeSet<Searchable>(new Comp());
        Iterator<Searchable> itr = searchMas.iterator();
        while (itr.hasNext()) {
            Searchable s = itr.next();
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
        while (itr.hasNext()) {
            Searchable s = itr.next();
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

    class Comp implements Comparator<Searchable> {
        @Override
        public int compare(Searchable a, Searchable b) {
            if (a.getClass() == b.getClass() && Objects.equals(a.getContentType(), "ARTICLE")) {
                if (Integer.compare(a.getProductName().length(), b.getProductName().length()) == 0) {
                    return a.getProductName().compareTo(b.getProductName());
                }
            }
            return Integer.compare(b.getProductName().length(), a.getProductName().length());
        }
    }
}
