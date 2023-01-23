package com.billy.solo.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.billy.solo.models.Game;
import com.billy.solo.models.User;
import com.billy.solo.services.GameService;
import com.billy.solo.services.UserService;

@Controller
public class GameController {
	@Autowired 
	private GameService gameService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/games")
	public String allGamesPage (Model viewModel, HttpSession session) {
		if (session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		Long userId = (Long) session.getAttribute("userId");
		User foundUser = userService.findById(userId);
		viewModel.addAttribute("games", gameService.getAllGames());
		viewModel.addAttribute("loggedUser", foundUser);
		return"games.jsp";
	}
	@GetMapping("/games/{id}")
	public String viewOneGamePage(Model viewModel, @PathVariable("id")Long id, HttpSession session) {
		if (session.getAttribute("userId") ==null) {
			return "redirect:/";
		}
		Long userId = (Long) session.getAttribute("userId");
		User foundUser = userService.findById(userId);
		viewModel.addAttribute("thisGame", gameService.getOneGame(id));
		viewModel.addAttribute("loggedUser", foundUser);
		return "viewgame.jsp";
	}
	
	@GetMapping("/games/new")
	public String newGamePage (@ModelAttribute("newGame") Game thisGame, Model viewModel, HttpSession session) {
		if (session.getAttribute("userId") ==null) {
			return "redirect:/";
		}
		Long userId = (Long) session.getAttribute("userId");
		User foundUser = userService.findById(userId);
		Integer[] possibleRatings= {1,2,3,4,5};
		viewModel.addAttribute("possibleRatings", possibleRatings);
		viewModel.addAttribute("thisUser", userService.findById(userId));
		viewModel.addAttribute("loggedUser", foundUser);
		return "newgame.jsp";
	}
	
	@PostMapping("/games/new")
	public String addBookToDB(
			@Valid @ModelAttribute("newGame") Game aNewGame,
			BindingResult result, Model viewModel, HttpSession session) {
		if (result.hasErrors()) { 
			Long userId = (Long) session.getAttribute("userId");
			User foundUser = userService.findById(userId);
			Integer[] possibleRatings= {1,2,3,4,5};
			viewModel.addAttribute("possibleRatings", possibleRatings);
			viewModel.addAttribute("thisUser", userService.findById(userId));
			viewModel.addAttribute("loggedUser", foundUser);
			return "newgame.jsp";
		}
		gameService.createdGame(aNewGame);
		return "redirect:/games";
	}
	
	
	@GetMapping("/games/{id}/edit")
	public String editOneGamePage(@Valid @PathVariable Long id, Model viewModel, HttpSession session) {
		if (session.getAttribute("userId") ==null) {
			return "redirect:/";
		}
		Game thisGame = gameService.getOneGame(id);
		Long userId=(Long) session.getAttribute("userId");
		User foundUser = userService.findById(userId);
		if (!userId.equals(thisGame.getGameCreator().getId())) {
			return "redirect:/games";
		}
		Integer[] possibleRatings= {1,2,3,4,5};
		viewModel.addAttribute("possibleRatings", possibleRatings);
		viewModel.addAttribute("loggedUser", foundUser);
		viewModel.addAttribute("thisGame", gameService.getOneGame(id));
		return "editgame.jsp";
		
	}
	@PutMapping("/games/{id}/edit")
	public String editGameInDB(
			@Valid @ModelAttribute("thisGame") Game changedGame,BindingResult result, @PathVariable Long id, HttpSession session, Model viewModel) {
		if(result.hasErrors()) {
			Long userId = (Long) session.getAttribute("userId");
			User foundUser = userService.findById(userId);
			Integer[] possibleRatings= {1,2,3,4,5};
			viewModel.addAttribute("possibleRatings", possibleRatings);
			viewModel.addAttribute("thisUser", userService.findById(userId));
			viewModel.addAttribute("loggedUser", foundUser);
			return "editgame.jsp";
		}
		gameService.updatedGame(changedGame);
		return "redirect:/games";
	}
	
	@RequestMapping(value="/games/{id}/delete", method={RequestMethod.GET, RequestMethod.DELETE})
	public String deleteFromDB(@PathVariable("id") Long id) {
		gameService.deleteGame(id);
		return "redirect:/games";
	}

}
