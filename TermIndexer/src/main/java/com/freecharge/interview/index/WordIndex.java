package com.freecharge.interview.index;

import java.util.concurrent.ConcurrentHashMap;

public class WordIndex {

    private static WordIndex wordIndex;
    private ConcurrentHashMap<String, Integer> index = new ConcurrentHashMap<String, Integer>();

    static {
        wordIndex = new WordIndex();
    }

    private WordIndex(){
    }


    public void indexWord(String word){
        if (index.containsKey(word)){
            index.put(word, index.get(word) + 1);
        } else {
            index.put(word, 1);
        }
    }

    public int getCountFor(String word){
        if (index.containsKey(word))
            return index.get(word);

        return 0;
    }


    public static WordIndex getInstance(){
        return wordIndex;
    }
}
