package com.freecharge.interview.http.resource;

import com.freecharge.interview.http.model.CountModel;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/")
public class WordCountResource {

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public CountModel getCountFor(@QueryParam("q") String word){
        return new CountModel();
    }
}
