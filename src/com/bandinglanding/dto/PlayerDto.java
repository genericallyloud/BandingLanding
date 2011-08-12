package com.bandinglanding.dto;

import java.util.List;

import com.bandinglanding.dao.DeckCardDao;
import com.bandinglanding.dao.GameCardDao;
import com.bandinglanding.model.Deck;
import com.bandinglanding.model.GameCard;
import com.bandinglanding.model.Player;
import com.googlecode.objectify.Key;

public class PlayerDto {
	public Player player;
	public List<GameCard> library;
	
	public PlayerDto(Player player){
		this.player = player;
		//fetch all the cards for my library
		this.library = new GameCardDao().findLibrary(new Key<Player>(Player.class,player.getId()));
	}
	
	
}
