package br.com.lucassolutions.schoolbus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/controller/user")
public class FileController {

	@RequestMapping("/fileView")
	public String filesView(){
		return "file";
	}
}
