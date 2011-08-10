package com.bandinglanding.model;

import java.io.Serializable;

import javax.persistence.Id;

import com.google.appengine.api.users.User;
import com.googlecode.objectify.Key;

public class Player implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id private Long id;
	private Key<Game> game;
	private User user;
	private int life = 20;
	
	public Player() {}
	
	public Player(Key<Game> game, Deck deck) {
		this.game = game;
		this.user = deck.getDeckOwner();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Key<Game> getGame() {
		return game;
	}
	public void setGame(Key<Game> game) {
		this.game = game;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}
	
	
	
}