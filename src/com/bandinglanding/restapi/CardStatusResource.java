package com.bandinglanding.restapi;


import java.io.IOException;
import java.nio.ByteBuffer;

import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import com.bandinglanding.dto.CardStatusDto;
import com.bandinglanding.model.Card;
import com.bandinglanding.model.CardStatus;
import com.bandinglanding.model.CardUpload;
import com.bandinglanding.model.Deck;
import com.bandinglanding.model.DeckCard;
import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.files.AppEngineFile;
import com.google.appengine.api.files.FileService;
import com.google.appengine.api.files.FileServiceFactory;
import com.google.appengine.api.files.FileWriteChannel;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

/**
 * Resource which has only one representation.
 * 
 */
public class CardStatusResource extends ServerResource {
	
	@Get
	public CardStatusDto checkStatus(){

		String cardName = getReference().getQueryAsForm().getFirstValue("cardName");

    	Objectify ofy = ObjectifyService.begin();

    	Card card = ofy.query(Card.class).filter("name", cardName).get();
    	if(card == null){
    		return new CardStatusDto(CardStatus.UPLOAD_AND_ADD);
    	}
    	
    	UserService userService = UserServiceFactory.getUserService();
    	User currUser = userService.getCurrentUser();
    	Deck deck = ofy.query(Deck.class).filter("deckOwner", currUser).get();
    	if(deck == null){
    		return new CardStatusDto(CardStatus.ADD_NO_UPLOAD);
    	}
    	DeckCard matchingCard = ofy.query(DeckCard.class).ancestor(deck).filter("card", card).get();
    	if(matchingCard == null){
    		return new CardStatusDto(CardStatus.ADD_NO_UPLOAD);
    	}else{
    		return new CardStatusDto(matchingCard);
    	}
		
	}
}