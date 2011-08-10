package com.bandinglanding.restapi;


import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import com.bandinglanding.dao.DeckDao;
import com.bandinglanding.dto.DeckDto;
import com.bandinglanding.model.Deck;

/**
 * Resource which has only one representation.
 * 
 */
public class GameResource extends ServerResource {
	
	@Post
	public String createGame(Deck deck){
		return "TODO";
	}

}