package com.bandinglanding.restapi;


import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import com.bandinglanding.dao.DeckDao;
import com.bandinglanding.dto.DeckDto;
import com.bandinglanding.model.Deck;

/**
 * Resource which has only one representation.
 * 
 */
public class DeckResource extends ServerResource {
	
	@Get
	public DeckDto find(){
		Deck deck;
		DeckDao deckDao = new DeckDao();
		String idString = (String) getRequestAttributes().get("id");
		if(idString == null){
			deck = deckDao.findDefaultForCurrentUser();
		}else{
			long deckId = Long.parseLong(idString);
			deck = deckDao.find(deckId);
		}
		return new DeckDto(deck);
	}

}