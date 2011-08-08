package com.bandinglanding.restapi;


import java.io.IOException;
import java.nio.ByteBuffer;

import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import com.bandinglanding.dao.DeckCardDao;
import com.bandinglanding.dao.DeckDao;
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
public class DeckCardResource extends ServerResource {
	
	@Delete
	public String remove(){
		String idString = (String) getRequestAttributes().get("id");
		long deckCardId = Long.parseLong(idString);
		Objectify ofy = ObjectifyService.begin();
    	Key<Deck> deck = new DeckDao().findDefaultKeyForCurrentUser();
    	if(deck == null){
    		return "No Deck!";
    	}
    	DeckCard fetched = new DeckCardDao().find(deck, deckCardId);
		if(fetched != null){
			ofy.delete(fetched);
			return "Deleted!";
		}else{
			return "Not found: " + deckCardId;
		}
		
	}
 
    @Put("json")
    public String updateCount(DeckCard deckCard) throws IOException {
		String idString = (String) getRequestAttributes().get("id");
		long deckCardId = Long.parseLong(idString);
		Objectify ofy = ObjectifyService.begin();
		
    	Key<Deck> deck = new DeckDao().findDefaultKeyForCurrentUser();
    	if(deck == null){
    		return "No Deck!";
    	}
    	DeckCard fetched = new DeckCardDao().find(deck, deckCardId);
		if(fetched != null){
			fetched.setCount(deckCard.getCount());
			ofy.put(fetched);
			return "Updated to "+ fetched.getCount() +"!";
		}else{
			return "Not Found:" + deckCardId;
		}
    }

}