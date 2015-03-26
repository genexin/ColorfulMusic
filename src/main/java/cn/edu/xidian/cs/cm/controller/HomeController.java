package cn.edu.xidian.cs.cm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author MiZhou
 */
@Controller
public class HomeController {

	@RequestMapping("/index")
	public String index(){
		return "/index";
	}
}
