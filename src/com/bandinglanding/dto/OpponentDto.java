package com.bandinglanding.dto;

import java.util.List;

import com.bandinglanding.dao.DeckCardDao;
import com.bandinglanding.model.Deck;
import com.bandinglanding.model.Player;
import com.googlecode.objectify.Key;

public class OpponentDto {
	public Player player;
	
	public OpponentDto(Player player){
		this.player = player;
	}
}
