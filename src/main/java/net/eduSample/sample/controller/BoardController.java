package net.eduSample.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = "/board/")
@Slf4j
public class BoardController {
	
	
	@RequestMapping(value = "/list")
	public void list() throws Exception {
		log.info("list !!!");
	}
}
