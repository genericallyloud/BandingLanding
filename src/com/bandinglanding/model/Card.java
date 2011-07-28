package com.bandinglanding.model;

import java.io.Serializable;

import javax.persistence.Id;

import com.google.appengine.api.blobstore.BlobKey;

public class Card implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id private Long id;
	private String name;
	private String text;
	private String flavorText;
	private boolean land;
	private boolean creature;
	private boolean permanent;
	private int power;
	private int toughness;
	private CardColor color;
	private int cost;
	private String imageUrl;

	private String types;
	private String rarity;
	private String expansion;
	private String cardNumber;
	private String artist;
	private BlobKey image;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getToughness() {
		return toughness;
	}
	public void setToughness(int toughness) {
		this.toughness = toughness;
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
	public BlobKey getImage() {
		return image;
	}
	public void setImage(BlobKey image) {
		this.image = image;
	}
}