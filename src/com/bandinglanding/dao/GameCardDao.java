package com.bandinglanding.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import sun.misc.GC;

import com.bandinglanding.dto.DeckCardListingDto;
import com.bandinglanding.model.Deck;
import com.bandinglanding.model.Game;
import com.bandinglanding.model.GameCard;
import com.bandinglanding.model.Player;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.util.DAOBase;

public class GameCardDao extends DAOBase {
	static{
		ObjectifyService.register(GameCard.class);
	}
	
	public GameCard find(Key<Player> controller, long id){
		return ofy().find(new Key<GameCard>(controller,GameCard.class,id));
	}
	
	/**
	 * A new game can be created based off of a deck - this allows us to get the initiating user
	 * and which deck they have chosen. From there, all of the GameCards can be generated and the player,
	 * etc.
	 * 
	 * @param deck
	 * @return
	 */
	public List<GameCard> createGameDeck(Key<Player>controller, Deck deck){
		List<DeckCardListingDto> listing = new DeckCardDao().findDeckCardDtosByDeck(deck);
		List<GameCard> library = new ArrayList<GameCard>();
		for(DeckCardListingDto entry : listing){
			int count = entry.deckCard.getCount();
			for(int i=0;i<count;i++){
				GameCard gc = new GameCard(entry.card,controller);
				library.add(gc);
			}
		}
		//every card is made, but lets shuffle them
		Collections.shuffle(library);
		//now set the index of the card in the library so we can persist the shuffle
		for(int i=0;i<library.size();i++){
			library.get(i).setIndex(i);
		}
		ofy().put(library);
		
		return library;
	}
}
