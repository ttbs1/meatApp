package br.com.meatApp.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meatApp.domain.User;
import br.com.meatApp.repositories.UserRepository;

@Service
public class DBService {

	@Autowired
	private UserRepository userRepository;
	
	public void instanciaDatabase() {
		User user1 = new User(1, "Valter", "valter@gmail.com", "123");
		User user2 = new User(2, "Saulo", "saulo@gmail.com", "456");
		userRepository.saveAll(Arrays.asList(user1, user2));
	}
}
