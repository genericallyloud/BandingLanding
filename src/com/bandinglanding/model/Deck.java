package com.bandinglanding.model;

import java.io.Serializable;

import javax.persistence.Id;

import com.bandinglanding.dto.DeckDto;
import com.google.appengine.api.users.User;

public class Deck implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id private Long id;
	private User deckOwner;
	private String deckName = "DEFAULT";
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getDeckOwner() {
		return deckOwner;
	}
	public void setDeckOwner(User deckOwner) {
		this.deckOwner = deckOwner;
	}
	public String getDeckName() {
		return deckName;
	}
	public void setDeckName(String deckName) {
		this.deckName = deckName;
	}
	
	
}