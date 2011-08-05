package com.bandinglanding.model;

import java.io.Serializable;

import javax.persistence.Id;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.google.appengine.api.users.User;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Parent;

public class DeckCard implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id private Long id;
	@Parent private Key<Deck> deck;
	private Key<Card> card;
	private String cardName; //denormalized - won't change
	private int count;
	
	public DeckCard() {}
	
	public DeckCard(Deck deck, Card card) {
		this.deck = new Key<Deck>(Deck.class,deck.getId());
		this.card = new Key<Card>(Card.class,card.getId());
		this.cardName = card.getName();
		this.count = 0;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@JsonIgnore
	public Key<Deck> getDeck() {
		return deck;
	}
	public void setDeck(Key<Deck> deck) {
		this.deck = deck;
	}
	@JsonIgnore
	public Key<Card> getCard() {
		return card;
	}
	public void setCard(Key<Card> card) {
		this.card = card;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	public void incrementCount() {
		this.count++;
	}
	
	public void decrementCount() {
		this.count--;
	}
	
}