package cn.edu.xidian.cs.cm.controller;

import cn.edu.xidian.cs.cm.entity.Singer;
import cn.edu.xidian.cs.cm.mapper.SingerMapper;
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
@RequestMapping("/singer")
public class SingerController {

	@Autowired
	private SingerMapper singerMapper;

	@RequestMapping("/{id}")
	public ResponseEntity<Singer> getSinger(@PathVariable("id") Integer id) {
		Singer singer = singerMapper.getSingerById(id);
		if (singer != null) {
			return new ResponseEntity<>(singer, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
}
