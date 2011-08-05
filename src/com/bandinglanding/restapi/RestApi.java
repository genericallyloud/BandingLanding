package com.bandinglanding.restapi;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import com.bandinglanding.ObjectifySetup;
import com.bandinglanding.model.Card;
import com.bandinglanding.model.Deck;
import com.bandinglanding.model.DeckCard;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

public class RestApi extends Application {

    /**
     * Creates a root Restlet that will receive all incoming calls.
     */
    @Override
    public Restlet createInboundRoot() {
    	ObjectifySetup.register();
        // Create a router Restlet that routes each call to a
        // new instance of HelloWorldResource.
        Router router = new Router(getContext());

        // Defines only one route
        router.attach("/hello",HelloWorldResource.class);
        router.attach("/card-status", CardStatusResource.class);
        router.attach("/upload-card/{cardId}",CardUploadResource.class);
        router.attach("/upload-card",CardUploadResource.class);
        

        router.attach("/deckcards/{id}",DeckCardResource.class);

        //put in authentication layer
        AuthFilter auth = new AuthFilter(getContext());
        auth.setNext(router);
        return auth;
    }
}