package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class WorkintechList<E> extends ArrayList<E> {

    @Override
    public boolean add(E e) {
        if (!this.contains(e)) {
            return super.add(e);
        }
        return false; // Eğer zaten varsa, ekleme yapma
    }

    public void sort() {
        Collections.sort((ArrayList<Comparable>) this);
    }

    @Override
    public boolean remove(Object o) {
        boolean removed = super.remove(o);
        this.sort(); // Her çıkarmadan sonra listeyi sıralar
        return removed;
    }
}
