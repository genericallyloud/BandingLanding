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
import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.files.AppEngineFile;
import com.google.appengine.api.files.FileService;
import com.google.appengine.api.files.FileServiceFactory;
import com.google.appengine.api.files.FileWriteChannel;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
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
	public Card find(){
		String idString = (String) getRequestAttributes().get("cardId");
		long cardId = Long.parseLong(idString);
		Objectify ofy = ObjectifyService.begin();
		
		return ofy.find(Card.class, cardId);
		
	}
 
    @Post("json")
    public String upload(CardUpload cardUpload) throws IOException {
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
    	
    	Objectify ofy = ObjectifyService.begin();
    	Key<Card> cardKey = ofy.put(card);
    	
        return url + " " + cardKey.toString();
    }

}