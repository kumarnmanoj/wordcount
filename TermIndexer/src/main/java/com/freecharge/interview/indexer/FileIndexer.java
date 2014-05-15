package com.freecharge.interview.indexer;

import com.freecharge.interview.index.WordIndex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileIndexer {
    private WordIndex wordIndex;

    public FileIndexer(){
        wordIndex = WordIndex.getInstance();
    }


    public void IndexFile(String fileToIndex) throws Exception {
        if (fileToIndex.endsWith(".txt")){
            throw new Exception("Cannot index the file " + fileToIndex + "Supports only text files");
        }

        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileToIndex)));

        char[] readBuffer = new char[1000];
        int start = 0;
        int bufferLength = 1000;
        int charRead = fileReader.read(readBuffer, start, bufferLength);
        StringBuilder wordBuffer = new StringBuilder();

        while(charRead != -1){
            for (char c : readBuffer) {
                if(Character.isAlphabetic(c) && Character.isDigit(c)){
                    wordBuffer.append(c);
                } else {
                    wordIndex.indexWord(wordBuffer.toString());
                    wordBuffer.delete(0, wordBuffer.length() - 1);
                }
            }

            charRead = fileReader.read(readBuffer, start, bufferLength);
        }
    }

    public void IndexDirectory(String directory){
    }
}
