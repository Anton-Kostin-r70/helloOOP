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
        Set<Searchable> result = new TreeSet<Searchable>(
                new Comparator() {
                    public int compare(Object a, Object b) {
                        Searchable a1 = (Searchable) a;
                        Searchable b1 = (Searchable) b;
                        if (a1.getClass() == b1.getClass() && Objects.equals(a1.getContentType(), "ARTICLE")) {
                            if (Integer.compare(a1.getProductName().length(), b1.getProductName().length()) == 0) {
                                return a1.getProductName().compareTo(b1.getProductName());
                            }
                        }
                        return Integer.compare(b1.getProductName().length(), a1.getProductName().length());
                    }
                }
        );
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
}
