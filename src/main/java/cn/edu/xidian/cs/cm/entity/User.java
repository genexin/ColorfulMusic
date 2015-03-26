package cn.edu.xidian.cs.cm.entity;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author MiZhou
 */
public class User implements Serializable {

	private static final long serialVersionUID = 2015_03L;

	private Integer id;
	private String username;
	private String password;
	private String email;
	private List<Song> songs;

	public User() {
	}

	public User(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + '}';
	}

}
