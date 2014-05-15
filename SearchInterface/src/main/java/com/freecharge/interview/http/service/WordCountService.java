package com.freecharge.interview.http.service;

import com.freecharge.interview.http.conf.WordCountConfiguration;
import com.freecharge.interview.http.resource.WordCountResource;
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
        environment.addResource(new WordCountResource());
    }

    public static void main(String[] args) throws Exception {
        new WordCountService().run(args);
    }
}
