package com.bandinglanding.model;

import java.io.Serializable;

import javax.persistence.Id;

import com.google.appengine.api.blobstore.BlobKey;

public class GameCard implements Serializable, CardDefinition{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id private Long id;
	private String name;
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
	
	private String imageUrl;
	private BlobKey image;
	
	public GameCard() {}
	
	public GameCard(CardDefinition cardDef) {
		this.name = cardDef.getName();
		this.color = cardDef.getColor();
		this.cost = cardDef.getCost();
		this.types = cardDef.getTypes();
		this.text = cardDef.getText();
		this.flavorText = cardDef.getFlavorText();
		this.powerToughness = cardDef.getPowerToughness();
		this.land = cardDef.isLand();
		this.creature = cardDef.isCreature();
		this.permanent = cardDef.isPermanent();
		this.rarity = cardDef.getRarity();
		this.expansion = cardDef.getRarity();
		this.cardNumber = cardDef.getCardNumber();
		this.artist = cardDef.getArtist();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String getPowerToughness() {
		return powerToughness;
	}
	@Override
	public void setPowerToughness(String powerToughness) {
		this.powerToughness = powerToughness;
	}

	/* (non-Javadoc)
	 * @see com.bandinglanding.model.CardDefinition#getName()
	 */
	@Override
	public String getName() {
		return name;
	}
	/* (non-Javadoc)
	 * @see com.bandinglanding.model.CardDefinition#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}
	/* (non-Javadoc)
	 * @see com.bandinglanding.model.CardDefinition#getText()
	 */
	@Override
	public String getText() {
		return text;
	}
	/* (non-Javadoc)
	 * @see com.bandinglanding.model.CardDefinition#setText(java.lang.String)
	 */
	@Override
	public void setText(String text) {
		this.text = text;
	}
	/* (non-Javadoc)
	 * @see com.bandinglanding.model.CardDefinition#getFlavorText()
	 */
	@Override
	public String getFlavorText() {
		return flavorText;
	}
	/* (non-Javadoc)
	 * @see com.bandinglanding.model.CardDefinition#setFlavorText(java.lang.String)
	 */
	@Override
	public void setFlavorText(String flavorText) {
		this.flavorText = flavorText;
	}
	/* (non-Javadoc)
	 * @see com.bandinglanding.model.CardDefinition#isLand()
	 */
	@Override
	public boolean isLand() {
		return land;
	}
	/* (non-Javadoc)
	 * @see com.bandinglanding.model.CardDefinition#setLand(boolean)
	 */
	@Override
	public void setLand(boolean land) {
		this.land = land;
	}
	/* (non-Javadoc)
	 * @see com.bandinglanding.model.CardDefinition#isCreature()
	 */
	@Override
	public boolean isCreature() {
		return creature;
	}
	/* (non-Javadoc)
	 * @see com.bandinglanding.model.CardDefinition#setCreature(boolean)
	 */
	@Override
	public void setCreature(boolean creature) {
		this.creature = creature;
	}
	/* (non-Javadoc)
	 * @see com.bandinglanding.model.CardDefinition#isPermanent()
	 */
	@Override
	public boolean isPermanent() {
		return permanent;
	}
	/* (non-Javadoc)
	 * @see com.bandinglanding.model.CardDefinition#setPermanent(boolean)
	 */
	@Override
	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}
	/* (non-Javadoc)
	 * @see com.bandinglanding.model.CardDefinition#getColor()
	 */
	@Override
	public CardColor getColor() {
		return color;
	}
	/* (non-Javadoc)
	 * @see com.bandinglanding.model.CardDefinition#setColor(com.bandinglanding.model.CardColor)
	 */
	@Override
	public void setColor(CardColor color) {
		this.color = color;
	}
	/* (non-Javadoc)
	 * @see com.bandinglanding.model.CardDefinition#getCost()
	 */
	@Override
	public int getCost() {
		return cost;
	}
	/* (non-Javadoc)
	 * @see com.bandinglanding.model.CardDefinition#setCost(int)
	 */
	@Override
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	/* (non-Javadoc)
	 * @see com.bandinglanding.model.CardDefinition#getRarity()
	 */
	@Override
	public String getRarity() {
		return rarity;
	}
	/* (non-Javadoc)
	 * @see com.bandinglanding.model.CardDefinition#setRarity(java.lang.String)
	 */
	@Override
	public void setRarity(String rarity) {
		this.rarity = rarity;
	}
	/* (non-Javadoc)
	 * @see com.bandinglanding.model.CardDefinition#getExpansion()
	 */
	@Override
	public String getExpansion() {
		return expansion;
	}
	/* (non-Javadoc)
	 * @see com.bandinglanding.model.CardDefinition#setExpansion(java.lang.String)
	 */
	@Override
	public void setExpansion(String expansion) {
		this.expansion = expansion;
	}
	/* (non-Javadoc)
	 * @see com.bandinglanding.model.CardDefinition#getCardNumber()
	 */
	@Override
	public String getCardNumber() {
		return cardNumber;
	}
	/* (non-Javadoc)
	 * @see com.bandinglanding.model.CardDefinition#setCardNumber(java.lang.String)
	 */
	@Override
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	/* (non-Javadoc)
	 * @see com.bandinglanding.model.CardDefinition#getArtist()
	 */
	@Override
	public String getArtist() {
		return artist;
	}
	/* (non-Javadoc)
	 * @see com.bandinglanding.model.CardDefinition#setArtist(java.lang.String)
	 */
	@Override
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public BlobKey getImage() {
		return image;
	}
	public void setImage(BlobKey image) {
		this.image = image;
	}
	/* (non-Javadoc)
	 * @see com.bandinglanding.model.CardDefinition#getTypes()
	 */
	@Override
	public String getTypes() {
		return types;
	}
	/* (non-Javadoc)
	 * @see com.bandinglanding.model.CardDefinition#setTypes(java.lang.String)
	 */
	@Override
	public void setTypes(String types) {
		this.types = types;
	}
}