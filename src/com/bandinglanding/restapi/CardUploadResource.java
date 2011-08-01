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
public class CardUploadResource extends ServerResource {
	
	/**@throws IOException 
	 * @Override
	protected Representation post(Representation entity)
			throws ResourceException {
		return new StringRepresentation("matched something");
	}*/
	
	@Get
	public Card find(){
		String idString = (String) getRequestAttributes().get("cardId");
		long cardId = Long.parseLong(idString);
		Objectify ofy = ObjectifyService.begin();
		
		return ofy.find(Card.class, cardId);
		
	}
 
    @Post("json")
    public String upload(CardUpload cardUpload) throws IOException {
    	UserService userService = UserServiceFactory.getUserService();
    	User currUser = userService.getCurrentUser();
    	if(currUser == null){
    		return "Not logged in";
    	}

    	Objectify ofy = ObjectifyService.begin();

    	Deck deck = ofy.query(Deck.class).filter("deckOwner", currUser).get();
    	if(deck == null){
    		//need to create and store a new deck
    		deck = new Deck();
    		deck.setDeckOwner(currUser);
    		ofy.put(deck);
    	}
    	
    	Card card = new Card(cardUpload);
    	// Get a file service
    	FileService fileService = FileServiceFactory.getFileService();

    	// Create a new Blob file with mime-type "image/jpeg"
    	AppEngineFile file = fileService.createNewBlobFile("image/jpeg");


    	// This time lock because we intend to finalize
    	boolean lock = true;
    	FileWriteChannel writeChannel = fileService.openWriteChannel(file, lock);

    	// This time we write to the channel using standard Java
    	writeChannel.write(ByteBuffer.wrap(cardUpload.getImageData()));

    	// Now finalize
    	writeChannel.closeFinally();

    	// Now read from the file using the Blobstore API
    	BlobKey blobKey = fileService.getBlobKey(file);
    	ImagesService imagesService = ImagesServiceFactory.getImagesService();
    	String url = imagesService.getServingUrl(blobKey);
    	card.setImage(blobKey);
    	card.setImageUrl(url);
    	
    	Key<Card> cardKey = ofy.put(card);
    	DeckCard deckCard = new DeckCard(deck, card);
    	ofy.put(deckCard);
    	
    	
        return url + " " + cardKey.toString();
    }

}