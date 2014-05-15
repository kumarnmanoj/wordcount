package com.freecharge.interview.http.service;

import com.freecharge.interview.http.conf.WordCountConfiguration;
import com.freecharge.interview.http.resource.WordCountResource;
import com.freecharge.interview.indexer.FileIndexer;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class WordCountService extends Service<WordCountConfiguration>{
    @Override
    public void initialize(Bootstrap<WordCountConfiguration> bootstrap) {
       bootstrap.setName("Word Count");
    }

    @Override
    public void run(WordCountConfiguration configuration, Environment environment) throws Exception {
        FileIndexer fileIndexer = new FileIndexer();
        System.out.println("Indexing the folder " + configuration.getFolderToIndex());
        fileIndexer.indexDirectory(configuration.getFolderToIndex());
        System.out.println("Indexing completed");
        environment.addResource(new WordCountResource());
    }

    public static void main(String[] args) throws Exception {
        new WordCountService().run(args);
    }
}
