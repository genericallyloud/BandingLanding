package com.bandinglanding.dto;

import com.bandinglanding.model.Card;
import com.bandinglanding.model.CardStatus;
import com.bandinglanding.model.DeckCard;

public class DeckCardListingDto {
	public Card card;
	public DeckCard deckCard;
	
	public DeckCardListingDto(Card card, DeckCard deckCard) {
		this.card = card;
		this.deckCard = deckCard;
	}
	
	
}
