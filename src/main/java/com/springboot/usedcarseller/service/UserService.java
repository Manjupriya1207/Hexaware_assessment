package com.springboot.usedcarseller.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.usedcarseller.exception.InvalidUsernameException;
import com.springboot.usedcarseller.exception.ResourceNotFoundException;
import com.springboot.usedcarseller.model.User;
import com.springboot.usedcarseller.repository.UserRepository;

@Service
public class UserService  {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passEncoder;
	public Optional<User> findById(Integer userId) {
        return userRepository.findById(userId);
    }
	
	public User signUp(User user) throws InvalidUsernameException {
		//check for username duplicacy 
		Optional<User> optional = userRepository.findByUsername(user.getUsername());
		if(optional.isPresent()) {
			throw new InvalidUsernameException("Username already in use");
		}
		
		//encrypt the password 
		String encryptedPass = passEncoder.encode(user.getPassword());
		user.setPassword(encryptedPass);
		
		
		return userRepository.save(user);
	}

	public User findByUsername(String username) {
		 //i am sure that username is valid as Spring has already checked it 
		return userRepository.findByUsername(username).get();
	}

	public User updateUserStatus(int id, boolean status) throws ResourceNotFoundException {
		Optional<User> optional =  userRepository.findById(id);
		if(optional.isEmpty())
			throw new ResourceNotFoundException("UserId Invalid");
		
		User user = optional.get();
		user.setEnabled(status);
		return userRepository.save(user);
	}
 
}
