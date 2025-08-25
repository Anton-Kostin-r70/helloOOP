package org.skypro.skyshop.product;

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
}
