package com.example.allymcgilloway.wordcounter;

import java.util.Comparator;
import java.util.Map;

class ValueComparator implements Comparator<Integer> {

    private Map<String, Integer> map;

    public ValueComparator(Map<String, Integer> map) {
        this.map = map;
    }

    public int compare(Integer a, Integer b) {
        return map.get(a).compareTo(map.get(b));
    }
}
