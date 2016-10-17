package sample.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.model.User;
import sample.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUser(Integer id) {
		return userRepository.findOne(id);
	}
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public void deleteUser(Integer id){
		userRepository.delete(id);
	}
}
