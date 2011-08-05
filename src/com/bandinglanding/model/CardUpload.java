package com.bandinglanding.model;

import java.io.Serializable;

public class CardUpload implements Serializable, CardDefinition{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name; //if only adding, not uploading, this will be the only field supplied
	private CardColor color;
	private int cost;
	private String types;
	private String text;
	private String flavorText;
	private String powerToughness;
	
	private boolean land;
	private boolean creature;
	private boolean permanent;

	private String rarity;
	private String expansion;
	private String cardNumber;
	private String artist;
	
	private byte[] imageData;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getFlavorText() {
		return flavorText;
	}

	public void setFlavorText(String flavorText) {
		this.flavorText = flavorText;
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

	public String getRarity() {
		return rarity;
	}

	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	public String getExpansion() {
		return expansion;
	}

	public void setExpansion(String expansion) {
		this.expansion = expansion;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	@Override
	public String getPowerToughness() {
		return powerToughness;
	}

	@Override
	public void setPowerToughness(String powerToughness) {
		this.powerToughness = powerToughness;
	}
	
	
	
	
}