package com.bandinglanding.dto;

import java.util.List;

import com.bandinglanding.dao.DeckCardDao;
import com.bandinglanding.model.Deck;
import com.googlecode.objectify.Key;

public class DeckDto {
	public Deck deck;
	public List<DeckCardListingDto> cards;
	
	public DeckDto(Deck deck){
		this.deck = deck;
		//need to get the list of cards
		cards = new DeckCardDao().findDeckCardDtosByDeck(deck);
	}
}
