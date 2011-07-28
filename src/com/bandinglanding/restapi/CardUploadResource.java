package com.bandinglanding.restapi;


import java.io.IOException;
import java.nio.ByteBuffer;

import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

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

    @Post("json")
    public String upload(CardUpload cardUpload) throws IOException {
    	// Get a file service
    	  FileService fileService = FileServiceFactory.getFileService();

    	  // Create a new Blob file with mime-type "text/plain"
    	  AppEngineFile file = fileService.createNewBlobFile("image/png");


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
    	
    	
    	
        return url;
    }

}