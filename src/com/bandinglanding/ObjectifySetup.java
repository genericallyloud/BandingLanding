package com.bandinglanding;

import com.bandinglanding.model.Card;
import com.bandinglanding.model.Deck;
import com.bandinglanding.model.DeckCard;
import com.googlecode.objectify.ObjectifyService;

public class ObjectifySetup {
	private static boolean registered = false;
	public static synchronized void register(){
		if(!registered){
			registered = true;

	    	//set up objectify
	    	ObjectifyService.register(Card.class);
	    	ObjectifyService.register(Deck.class);
	    	ObjectifyService.register(DeckCard.class);
		}
	}
}
