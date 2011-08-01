package com.bandinglanding.dto;

import com.bandinglanding.model.CardStatus;
import com.bandinglanding.model.DeckCard;

public class CardStatusDto {
	public CardStatus cardStatus;
	public DeckCard card;
	
	public CardStatusDto(DeckCard card) {
		cardStatus = CardStatus.ALREADY_ADDED;
		this.card = card;
	}
	
	public CardStatusDto(CardStatus cardStatus) {
		this.cardStatus = cardStatus; 
	}
}
