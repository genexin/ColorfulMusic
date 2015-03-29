package cn.edu.xidian.cs.cm.controller;

import cn.edu.xidian.cs.cm.entity.Album;
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
@RequestMapping("/album")
public class AlbumController {

	@RequestMapping("/{id}")
	public ResponseEntity<Album> getAlbum(@PathVariable("id")Integer id){
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
}
