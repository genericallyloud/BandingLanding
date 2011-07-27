package com.bandinglanding.restapi;

import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import com.bandinglanding.model.CardUpload;

/**
 * Resource which has only one representation.
 * 
 */
public class CardUploadResource extends ServerResource {
	
	/**@Override
	protected Representation post(Representation entity)
			throws ResourceException {
		return new StringRepresentation("matched something");
	}*/

    @Post("json")
    public String upload(CardUpload cardUpload) {
    	
        return cardUpload.getName();
    }

}