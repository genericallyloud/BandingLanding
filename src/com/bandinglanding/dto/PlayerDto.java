package com.bandinglanding.dto;

import java.util.List;

import com.bandinglanding.dao.DeckCardDao;
import com.bandinglanding.model.Deck;
import com.bandinglanding.model.Player;
import com.googlecode.objectify.Key;

public class PlayerDto {
	public Player player;
	
	
	public PlayerDto(Player player){
		this.player = player;
	}
}
