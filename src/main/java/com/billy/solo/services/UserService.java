package com.billy.solo.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.billy.solo.models.LoginUser;
import com.billy.solo.models.User;
import com.billy.solo.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public User register(User newUser, BindingResult result) {
		if (!newUser.getConfirmedPassword().equals(newUser.getPassword())) {
			result.rejectValue("confirmedPassword", "Matches", "your passwords must match");
		}
		Optional<User> optionalUser = userRepo.findByEmail(newUser.getEmail());
		if (optionalUser.isPresent()) {
			result.rejectValue("email", "Matches", "email already registered");
		}
		if(result.hasErrors()) {
			return null;
		}else {
			String hashedPassword = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			newUser.setPassword(hashedPassword);
			return userRepo.save(newUser);
		}
	}
	
	public User login(LoginUser newLogin, BindingResult result) {
		Optional <User> optionalUser = userRepo.findByEmail(newLogin.getLoginEmail());
		if (!optionalUser.isPresent()) {
			result.rejectValue("loginEmail", "Matches", "invalid");
			result.rejectValue("loginPassword", "Matches", "Invalid");
			return null;
		}
		User thisUser =optionalUser.get();
		if(!BCrypt.checkpw(newLogin.getLoginPassword(), thisUser.getPassword())) {
			result.rejectValue("loginEmail", "Matches", "invalid");
			result.rejectValue("loginPassword", "Matches", "Invalid");
			return null;
		}
		return thisUser;
	}
	public User findById(Long id) {
		Optional<User> optionalUser= userRepo.findById(id);
		return optionalUser.orElseGet(() -> null);
	}
	public User findByEmail(String email) {
		Optional<User> optionalUser= userRepo.findByEmail(email);
		return optionalUser.orElseGet(() -> null);
	}
	public User updateUser(User newUser) {
		return userRepo.save(newUser);
	}
	public void deleteUser(Long id) {
		userRepo.deleteById(id);
	}
}
