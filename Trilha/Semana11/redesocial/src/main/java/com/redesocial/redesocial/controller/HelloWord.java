package com.redesocial.redesocial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWord {
	
	@RequestMapping("/java")
	@ResponseBody
		public String ola() {
		return "testando";
}
	
}
