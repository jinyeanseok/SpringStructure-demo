package net.eduSample.sample.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = "/admin/")
@Slf4j
public class AdminController {

	@RequestMapping(value = "/index", method=RequestMethod.GET)
	public void idex() throws Exception {
		log.info("index Page");
	}
}
