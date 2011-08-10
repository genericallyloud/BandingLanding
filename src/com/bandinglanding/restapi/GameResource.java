package com.bandinglanding.restapi;


import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import com.bandinglanding.dao.DeckDao;
import com.bandinglanding.dao.GameDao;
import com.bandinglanding.dao.PlayerDao;
import com.bandinglanding.dto.DeckDto;
import com.bandinglanding.dto.GameDto;
import com.bandinglanding.model.Deck;
import com.bandinglanding.model.Game;
import com.bandinglanding.model.Player;
import com.googlecode.objectify.Key;

/**
 * Resource which has only one representation.
 * 
 */
public class GameResource extends ServerResource {
	
	@Get
	public GameDto find(){
		String idString = (String) getRequestAttributes().get("id");
		if(idString == null){
			long gameId = Long.parseLong(idString);
			Key<Game> gameKey = new Key<Game>(Game.class,gameId);
			Player p = new PlayerDao().findForCurrentUser(gameKey);
			return new GameDto(p);
		}else{
			throw new RuntimeException("This should be a 404");
		}
	}
	
	@Post("json")
	public Game createGame(Deck deck){
		Deck fetched = new DeckDao().find(deck.getId());
		return new GameDao().create(fetched);
	}

}