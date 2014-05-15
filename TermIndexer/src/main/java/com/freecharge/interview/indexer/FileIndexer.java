package com.freecharge.interview.indexer;

import com.freecharge.interview.index.WordIndex;

import java.io.*;
import java.util.Arrays;

public class FileIndexer {
    private WordIndex wordIndex;

    public FileIndexer(){
        wordIndex = WordIndex.getInstance();
    }


    public void indexFile(String fileToIndex) throws Exception {
        if (!fileToIndex.endsWith(".txt")){
            throw new Exception("Cannot index the file " + fileToIndex + " Supports only text files");
        }

        System.out.println("Indexing the file " + fileToIndex);

        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileToIndex)));

        char[] readBuffer = new char[1000];
        int start = 0;
        int bufferLength = 1000;
        int charRead = fileReader.read(readBuffer, start, bufferLength);
        StringBuilder wordBuffer = new StringBuilder();

        while(charRead != -1){
            for (char c : readBuffer) {
                if(Character.isAlphabetic(c) || Character.isDigit(c)){
                    wordBuffer.append(c);
                } else {
                    String stringToIndex = wordBuffer.toString().trim();
                    if (!stringToIndex.isEmpty()){
                        wordIndex.indexWord(stringToIndex);
                    }
                    wordBuffer = new StringBuilder();
                }
            }
            Arrays.fill(readBuffer, ' ');
            charRead = fileReader.read(readBuffer, 0, bufferLength);
        }
    }

    public void indexDirectory(String directoryPath) throws Exception {
        File folder = new File(directoryPath);

        File[] txtFilesInTheDirectory = folder.listFiles(new FileFilter() {

            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".txt");
            }
        });

        for (File file : txtFilesInTheDirectory) {
            indexFile(file.getAbsolutePath());
        }
    }
}
