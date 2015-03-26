package cn.edu.xidian.cs.cm.controller;

import cn.edu.xidian.cs.cm.entity.User;
import cn.edu.xidian.cs.cm.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author MiZhou
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserMapper userMapper;

	@RequestMapping("/register")
	public String register() {
		return "/register";
	}

	@RequestMapping("/user_register")
	public ResponseEntity<User> register(
			@RequestParam("email") String email,
			@RequestParam("username") String username,
			@RequestParam("password") String password) {
		User user = new User(username, password, email);
		userMapper.addUser(user);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/user_login")
	public ResponseEntity<User> login(@RequestParam("username") String username, @RequestParam("password") String password) {
		return getUserResponseEntity(userMapper.getUserByNameAndPass(username, password));
	}

	@RequestMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") Integer id) {
		return getUserResponseEntity(userMapper.getUserById(id));
	}

	private ResponseEntity<User> getUserResponseEntity(User user) {
		if (user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/collection")
	public void collectSong(@RequestParam("userId") Integer userId, @RequestParam("songId") Integer songId) {
		System.out.println(userId + " --> " + songId);
	}

}
