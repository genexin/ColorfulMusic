package cn.edu.xidian.cs.cm.controller;

import cn.edu.xidian.cs.cm.entity.Song;
import cn.edu.xidian.cs.cm.mapper.SongMapper;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Mi Zhou
 */
@Controller
@RequestMapping("/song")
public class SongController {

	@Autowired
	private SongMapper songMapper;

	@RequestMapping("/{offset}/{num}")
	public ResponseEntity<List<Song>> getSongs(HttpServletResponse response,
			@PathVariable("offset") int offset,
			@PathVariable("num") int num) {
		List<Song> songs = songMapper.getSongs(offset, num);
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:8383");
		if (songs != null) {
			return new ResponseEntity<>(songs, HttpStatus.OK);
		}
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
