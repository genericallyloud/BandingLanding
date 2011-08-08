package com.bandinglanding.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bandinglanding.model.Card;
import com.bandinglanding.model.Deck;
import com.bandinglanding.model.DeckCard;
import com.bandinglanding.dto.DeckCardListingDto;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.util.DAOBase;

public class DeckCardDao extends DAOBase {
	static{
		ObjectifyService.register(DeckCard.class);
	}
	
	public List<DeckCard> findByDeck(Key<Deck> deckKey){
		Iterable<DeckCard> deckCardIter = fetchByDeck(deckKey);
		List<DeckCard> deckCards = new ArrayList<DeckCard>();
		for(DeckCard dc : deckCardIter){
			deckCards.add(dc);
		}
		return deckCards;
	}

	public List<DeckCard> findByDeck(Deck deck) {
		return findByDeck(new Key<Deck>(Deck.class,deck.getId()));
	}
	
	public List<DeckCardListingDto> findDeckCardDtosByDeck(Key<Deck> deckKey){
		Iterable<DeckCard> deckCardIter = fetchByDeck(deckKey);
		List<Key<Card>> cardKeys = new ArrayList<Key<Card>>();
		for(DeckCard dc : deckCardIter){
			cardKeys.add(dc.getCard());
		}
		//batch retrieve the matching card data to do a manual join
		Map<Key<Card>, Card> cards = ofy().get(cardKeys);
		//join the DeckCards with the Cards
		List<DeckCardListingDto> listing = new ArrayList<DeckCardListingDto>();
		for(DeckCard dc : deckCardIter){
			Card c = cards.get(dc.getCard());
			listing.add(new DeckCardListingDto(c, dc));
		}
		return listing;
	}
	
	public List<DeckCardListingDto> findDeckCardDtosByDeck(Deck deck) {
		return findDeckCardDtosByDeck(new Key<Deck>(Deck.class,deck.getId()));
	}
	
	private Iterable<DeckCard> fetchByDeck(Key<Deck> deckKey){
		return ofy().query(DeckCard.class).ancestor(deckKey).fetch();
	}
	
	public DeckCard find(Key<Deck> deck, long id){
		return find(new Key<DeckCard>(deck,DeckCard.class,id));
	}
	
	public DeckCard find(Key<DeckCard> deckCardKey){
		return ofy().get(deckCardKey);
	}
}
