package com.bandinglanding.model;

public interface CardDefinition {

	public abstract String getName();

	public abstract void setName(String name);

	public abstract String getText();

	public abstract void setText(String text);

	public abstract String getFlavorText();

	public abstract void setFlavorText(String flavorText);

	public abstract boolean isLand();

	public abstract void setLand(boolean land);

	public abstract boolean isCreature();

	public abstract void setCreature(boolean creature);

	public abstract boolean isPermanent();

	public abstract void setPermanent(boolean permanent);

	public abstract String getPowerToughness();

	public abstract void setPowerToughness(String powerToughness);

	public abstract CardColor getColor();

	public abstract void setColor(CardColor color);

	public abstract int getCost();

	public abstract void setCost(int cost);

	public abstract String getRarity();

	public abstract void setRarity(String rarity);

	public abstract String getExpansion();

	public abstract void setExpansion(String expansion);

	public abstract String getCardNumber();

	public abstract void setCardNumber(String cardNumber);

	public abstract String getArtist();

	public abstract void setArtist(String artist);

	public abstract String getTypes();

	public abstract void setTypes(String types);

}