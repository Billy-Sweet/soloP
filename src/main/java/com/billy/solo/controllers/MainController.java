package com.billy.solo.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.billy.solo.models.LoginUser;
import com.billy.solo.models.User;
import com.billy.solo.services.UserService;

@Controller
public class MainController {

	@Autowired
	private UserService userServ;
	
	@GetMapping("/")
	public String loginRegPage(@ModelAttribute("registerUser") User newUser, @ModelAttribute("loginUser") LoginUser loginUser) {
		return "home.jsp";
	}


	@GetMapping("/dashboard")
		public String dashboard(HttpSession session, Model viewModel) {
	  	if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
	
		Long userId = (Long) session.getAttribute("userId");
		viewModel.addAttribute("loggedUser", userServ.findById(userId));
			return "games.jsp";
		}

	@PostMapping("/register")
		public String registerUser(@Valid @ModelAttribute("registerUser")User newUser, BindingResult result,
				@ModelAttribute("loginUser") LoginUser loginUser,HttpSession session) {
			User changedUser = userServ.register(newUser,  result);
			if(result.hasErrors()) {
					return"home.jsp";
			}
			session.setAttribute("userId", changedUser.getId());
			return "redirect:/games";
		}
	@PostMapping("/login")
	public String loginUser(@Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult result,
			@ModelAttribute("registerUser") User newUser, HttpSession session) {
		User foundUser = userServ.login(loginUser,  result);
		if (result.hasErrors()) {
			return "home.jsp";
		}
		session.setAttribute("userId", foundUser.getId());
		return "redirect:/games";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	
	
	
}
