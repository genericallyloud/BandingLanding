package com.bandinglanding.restapi;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import com.bandinglanding.model.Card;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

public class RestApi extends Application {

    /**
     * Creates a root Restlet that will receive all incoming calls.
     */
    @Override
    public Restlet createInboundRoot() {
    	//set up objectify
    	ObjectifyService.register(Card.class);
    	
        // Create a router Restlet that routes each call to a
        // new instance of HelloWorldResource.
        Router router = new Router(getContext());

        // Defines only one route
        router.attach("/hello",HelloWorldResource.class);
        router.attach("/upload-card/{cardId}",CardUploadResource.class);
        router.attach("/upload-card",CardUploadResource.class);

        return router;
    }
}