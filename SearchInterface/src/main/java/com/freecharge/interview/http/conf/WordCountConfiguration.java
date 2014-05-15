package com.freecharge.interview.http.conf;

import com.yammer.dropwizard.config.Configuration;

public class WordCountConfiguration extends Configuration{
    private String folderToIndex;

    public void setFolderToIndex(String folderToIndex){
        this.folderToIndex = folderToIndex;
    }

    public String getFolderToIndex(){
        return this.folderToIndex;
    }
}
