package cn.edu.xidian.cs.cm.controller;

import cn.edu.xidian.cs.cm.entity.Song;
import cn.edu.xidian.cs.cm.mapper.SongMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author MiZhou
 */
@Controller
@RequestMapping("/song")
public class SongController {

	@Autowired
	private SongMapper songMapper;

	@RequestMapping("/{offset}/{num}")
	public ResponseEntity<List<Song>> getSongs(@PathVariable("offset")int offset, @PathVariable("num") int num) {
		List<Song> songs = songMapper.getSongs(offset, num);
		if (songs != null){
			return new ResponseEntity<>(songs, HttpStatus.OK);
		}
		System.out.println("Songs is null");
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@RequestMapping("/{id}")
	public ResponseEntity<Song> getSong(@PathVariable("id") Integer id) {
		Song song = songMapper.getSong(id);
		if (song != null) {
			return new ResponseEntity<>(song, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
}
