package com.bandinglanding.restapi;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 * Resource which has only one representation.
 * 
 */
public class CardUploadResource extends ServerResource {

    @Get
    public String represent() {
        return "hello, world (from the cloud!)";
    }

}