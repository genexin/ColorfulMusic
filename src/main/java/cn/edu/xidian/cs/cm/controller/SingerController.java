package cn.edu.xidian.cs.cm.controller;

import cn.edu.xidian.cs.cm.entity.Singer;
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
public class SingerController {

	@RequestMapping("/{id}")
	public ResponseEntity<Singer> getSinger(@PathVariable("id")Integer id){
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
}
