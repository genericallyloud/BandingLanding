package com.bandinglanding.dto;

import java.util.List;

import com.bandinglanding.dao.DeckCardDao;
import com.bandinglanding.dao.GameDao;
import com.bandinglanding.dao.PlayerDao;
import com.bandinglanding.model.Deck;
import com.bandinglanding.model.Game;
import com.bandinglanding.model.Player;
import com.googlecode.objectify.Key;

public class GameDto {
	public Game game;
	public PlayerDto playerDto;
	public OpponentDto opponentDto;
	
	//Load up a game from the perspective of a given player
	public GameDto(Player player){
		//get the game
		game = new GameDao().find(player.getGame());
		//load up the player dto
		playerDto = new PlayerDto(player);
		//use the game to find another player that is not me. This is the opponent
		Player opponent = new PlayerDao().findOpponent(player);
		if(opponent != null){
			opponentDto = new OpponentDto(opponent);
		}
	}
}
