package org.skypro.skyshop.product;

import org.skypro.skyshop.exception.BestResultNotFound;

public class SearchEngine {
    private Searchable[] searchMas;

    public SearchEngine(int count) {
        searchMas = new Searchable[count];
    }

    public Searchable[] search(String str) {
        Searchable[] result = new Searchable[5];
        int index = 0;
        for (int i = 0; i < searchMas.length && searchMas[i] != null; i++) {
            if (index == 5) {
                break;
            }
            if (searchMas[i].getSeachTerm(str).contains(str)) {
                result[index] = searchMas[i];
                index++;
            }
        }
        return result;
    }

    public boolean add(Searchable o) {
        for (int i = 0; i < searchMas.length; i++) {
            if (searchMas[i] == null && o != null) {
                searchMas[i] = o;
                return true;
            }
        }
        return false;
    }

    //frequency-semantic analysis was used
    public Searchable getBestResult(String search) throws BestResultNotFound {
        int maxWeight = 0;
        Searchable result = null;
        for (int i = 0; searchMas[i] != null && i < searchMas.length; i++) {
            int weight = searchMas[i].getSeachTerm(search).split(search, -1).length - 1;
            if (maxWeight <= weight && weight > 0) {
                maxWeight = weight;
                result = searchMas[i];
            }
        }
        if (result == null) {
            throw new BestResultNotFound("Не нашлось подходящей статьи");
        }
        return result;
    }
}
