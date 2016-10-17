package sample.controllers;


import jersey.repackaged.com.google.common.collect.Maps;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sample.model.User;
import sample.services.UserService;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

	private static final Logger LOGGER = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> getUsers() {
		LOGGER.debug("All Users requested");
		return userService.getAllUsers();
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public Map<String, Object> getUser(@PathVariable Integer id) {
		LOGGER.debug("A User with id " + id + " requested");
		Map<String, Object> mapSet = Maps.newHashMap();
		User user = this.userService.getUser(id);

		if(null != user ) {
			mapSet.put("success", true);
			mapSet.put("data", user);
			mapSet.put("message", "successful");
		} else {
			mapSet.put("success", false);
			mapSet.put("message", "error:no user found");
		}
		return mapSet;
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> signUp(@RequestBody User reqUser) {
		LOGGER.debug("Create a user");
		User user = this.userService.getUser(reqUser.getId());
		Map<String, Object> map = Maps.newHashMap();
		if(null != user ) {
			map.put("success", false);
			map.put("message", "userId already exist");

		} else {
		   user = new User(reqUser.getId(),reqUser.getFirstname(),reqUser.getLastname(),reqUser.getAddress(),reqUser.getPhonenumber());
			this.userService.saveUser(user);
			map.put("success", true);
		}
		return map;
	}
	@RequestMapping(value = "/delete", method = RequestMethod.PUT)
	public @ResponseBody Map<String, Object> delete(@RequestBody User reqUser) {
		LOGGER.debug("Delete a user");
		User user = this.userService.getUser(reqUser.getId());
		Map<String, Object> map = Maps.newHashMap();
		if(null != user ) {
			this.userService.deleteUser(reqUser.getId());
			map.put("success", true);
		
		} else {
			map.put("success", false);
			map.put("message", "user does not exist");	
		}
		return map;
	} 
	
	@RequestMapping(value = "/updateUserAddress", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> updateUserPassword(@RequestBody User reqUser) {
		LOGGER.debug("Delete a user");
		User user = this.userService.getUser(reqUser.getId());
		Map<String, Object> map = Maps.newHashMap();
		if(null != user ) {
			user.setAddress(reqUser.getAddress());
			this.userService.saveUser(user);	
			map.put("success", true);
		
		} else {
			map.put("success", false);
			map.put("message", "user does not exist");	
		}
		return map;
	}
}
