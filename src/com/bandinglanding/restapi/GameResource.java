package com.bandinglanding.restapi;


import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Options;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;
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
	
	@Options
	public void doOptions(Representation entity) {
	    Form responseHeaders = (Form) getResponse().getAttributes().get("org.restlet.http.headers");
	    if (responseHeaders == null) {
	        responseHeaders = new Form();
	        getResponse().getAttributes().put("org.restlet.http.headers", responseHeaders);
	    }
	    responseHeaders.add("Access-Control-Allow-Origin", "http://localhost:8888");
	    responseHeaders.add("Access-Control-Allow-Methods", "GET,OPTIONS");
	    responseHeaders.add("Access-Control-Allow-Headers", "Content-Type");
	    responseHeaders.add("Access-Control-Allow-Credentials", "true");
	}
	
	@Get
	public GameDto find(){
		String idString = (String) getRequestAttributes().get("id");
		if(idString != null){
			Form responseHeaders = (Form) getResponse().getAttributes().get("org.restlet.http.headers");
		    if (responseHeaders == null) {
		        responseHeaders = new Form();
		        getResponse().getAttributes().put("org.restlet.http.headers", responseHeaders);
		    }
		    responseHeaders.add("Access-Control-Allow-Origin", "http://localhost:8888");
		    responseHeaders.add("Access-Control-Allow-Methods", "GET,OPTIONS");
		    responseHeaders.add("Access-Control-Allow-Headers", "Content-Type");
		    responseHeaders.add("Access-Control-Allow-Credentials", "true");
			
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
		Deck fetched;
		if(deck==null){
			fetched = new DeckDao().findDefaultForCurrentUser();
		}else{
			fetched = new DeckDao().find(deck.getId());
		}
		return new GameDao().create(fetched);
	}

}