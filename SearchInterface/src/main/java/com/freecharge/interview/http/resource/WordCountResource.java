package com.freecharge.interview.http.resource;

import com.freecharge.interview.http.model.CountModel;
import com.freecharge.interview.index.WordIndex;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/")
public class WordCountResource {

    private WordIndex index = WordIndex.getInstance();

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public CountModel getCountFor(@QueryParam("q") String word){
        CountModel countModel = new CountModel();
        countModel.setCount(index.getCountFor(word));
        return countModel;
    }
}
