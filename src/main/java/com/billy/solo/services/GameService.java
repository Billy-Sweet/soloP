package com.billy.solo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billy.solo.models.Game;
import com.billy.solo.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
	public Game createdGame(Game newGame) {
		return gameRepository.save(newGame);
	}
	
	public List<Game> getAllGames(){
		return gameRepository.findAll();
	}
	public Game getOneGame(Long id) {
		Optional<Game> optionalGame = gameRepository.findById(id);
		if(optionalGame.isPresent()) {
			return optionalGame.get();
			
		}else {
			return null; 
		}
	}
	public Game updatedGame (Game changedGame) {
		return gameRepository.save(changedGame);
	}
	public void deleteGame(Long id) {
		gameRepository.deleteById(id);
	}
}
