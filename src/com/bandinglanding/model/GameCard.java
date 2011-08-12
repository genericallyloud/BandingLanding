package com.bandinglanding.model;

import java.io.Serializable;

import javax.persistence.Id;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.google.appengine.api.blobstore.BlobKey;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Parent;

public class GameCard implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id private Long id;
	private Key<Player> controller;
	private GameCardLocation location = GameCardLocation.LIBRARY;
	private int index;
	
	private String name;
	private CardColor color;
	private int cost;
	private String text;
	private String powerToughness;
	
	private boolean land;
	private boolean creature;
	private boolean permanent;
	
	private String imageUrl;
	
	public GameCard() {}
	
	public GameCard(Card card, Key<Player> controller) {
		this.name = card.getName();
		this.color = card.getColor();
		this.cost = card.getCost();
		this.text = card.getText();
		this.powerToughness = card.getPowerToughness();
		this.land = card.isLand();
		this.creature = card.isCreature();
		this.permanent = card.isPermanent();
		this.imageUrl = card.getImageUrl();
		
		this.controller = controller;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@JsonIgnore
	public Key<Player> getController() {
		return controller;
	}

	public void setController(Key<Player> controller) {
		this.controller = controller;
	}

	public GameCardLocation getLocation() {
		return location;
	}

	public void setLocation(GameCardLocation location) {
		this.location = location;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getPowerToughness() {
		return powerToughness;
	}
	public void setPowerToughness(String powerToughness) {
		this.powerToughness = powerToughness;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isLand() {
		return land;
	}
	public void setLand(boolean land) {
		this.land = land;
	}
	public boolean isCreature() {
		return creature;
	}
	public void setCreature(boolean creature) {
		this.creature = creature;
	}
	public boolean isPermanent() {
		return permanent;
	}
	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}
	public CardColor getColor() {
		return color;
	}
	public void setColor(CardColor color) {
		this.color = color;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}