package cn.edu.xidian.cs.cm.controller;

import cn.edu.xidian.cs.cm.entity.Song;
import cn.edu.xidian.cs.cm.entity.User;
import cn.edu.xidian.cs.cm.mapper.UserMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

	@RequestMapping(method = RequestMethod.POST, value = "/user_register")
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
	public ResponseEntity<Integer> login(
			@RequestParam("username") String username,
			@RequestParam("password") String password) {
		Integer id = userMapper.getUserId(username, password);
		if (id != null) {
			return new ResponseEntity<>(id, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@RequestMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") Integer id) {
		User user = userMapper.getUserById(id);
		if (user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<User> delUser(@PathVariable("id") Integer id) {
		User user = userMapper.getUserById(id);
		if (user != null) {
			userMapper.delUserById(id);
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		userMapper.updateUser(user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/{userId}/collection")
	public ResponseEntity<List<Song>> getUserSongs(@PathVariable("userId") Integer userId) {
		List<Song> userSongs = userMapper.getUserSongs(userId);
		if (userSongs == null || userSongs.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(userSongs, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/collection/{userId}/{songId}")
	public ResponseEntity<Void> collectSong(@PathVariable("userId") Integer userId, @PathVariable("songId") Integer songId) {
		userMapper.collectSong(userId, songId);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

}
