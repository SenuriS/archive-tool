package com.fg.archive.tool.master.common;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.HttpHandler;



public class CommonFunctions {

    public static HttpHeaders httpHeaders(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_NDJSON);
        return httpHeaders;
    }
}
