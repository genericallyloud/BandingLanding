package com.bandinglanding.restapi;


import java.io.IOException;
import java.nio.ByteBuffer;

import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import com.bandinglanding.model.Card;
import com.bandinglanding.model.CardUpload;
import com.bandinglanding.model.Deck;
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
public class DeckResource extends ServerResource {
	
	/**@throws IOException 
	 * @Override
	protected Representation post(Representation entity)
			throws ResourceException {
		return new StringRepresentation("matched something");
	}*/
	
	@Get
	public Deck find(){
		UserService userService = UserServiceFactory.getUserService();
    	User currUser = userService.getCurrentUser();
    	Objectify ofy = ObjectifyService.begin();

    	return ofy.query(Deck.class).filter("deckOwner", currUser).get();
		
	}

}