package cn.edu.xidian.cs.cm.entity;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author MiZhou
 */
public class Singer implements Serializable {

	private static final long serialVersionUID = 2015_03L;

	private Integer id;
	private String name;
	private List<Album> albums;
	private List<Song> songs;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	@Override
	public String toString() {
		return "Singer{" + "id=" + id + ", name=" + name + '}';
	}

}
