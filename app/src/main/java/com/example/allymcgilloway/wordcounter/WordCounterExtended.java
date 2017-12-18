package com.example.allymcgilloway.wordcounter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by allymcgilloway on 13/12/2017.
 */

public class WordCounterExtended {

    private Map<String, Integer> concordance;
    private String[] words;

    public WordCounterExtended(String text) {
        this.concordance = new HashMap<String, Integer>();
        this.words = text.toLowerCase().split("[,\\s]+");

        for (String word : words) {
            if (concordance.get(word) == null) {
                concordance.put(word, 1);
            } else {
                concordance.put(word, concordance.get(word) + 1);
            }
        }
    }

    public int getCount() {
        return this.words.length;
    }

    public int getOccurrencesCount(String word) {
        return concordance.get(word);
    }

    public String toString() {
        String output = "Total Words: " + words.length + "\n";

//        for (String key: concordance.keySet()) {
//            output += key + " : " + concordance.get(key) + "\n";
//        }

        return output + sortedConcordance();
    }

    public String sortedConcordance () {
        //https://stackoverflow.com/questions/21054415/how-to-sort-a-hashmap-by-the-integer-value
        String sortedHashMap = "";

        Object[] array = this.concordance.entrySet().toArray();
        Arrays.sort(array, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Map.Entry<String, Integer>) o2).getValue()
                        .compareTo(((Map.Entry<String, Integer>) o1).getValue());
            }
        });

        for (Object e : array) {
            sortedHashMap += (((Map.Entry<String, Integer>) e).getKey() + " : "
                    + ((Map.Entry<String, Integer>) e).getValue()) + "\n";
        }
        return sortedHashMap;
    }
}


