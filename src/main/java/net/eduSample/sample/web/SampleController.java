package net.eduSample.sample.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import net.eduSample.sample.service.SampleService;

@Controller
@RequestMapping(value = "/sample/")
@Slf4j
public class SampleController {
	
	@Resource(name = "SampleService")
	private SampleService sampleService;
	
	@RequestMapping(value = "/testRequest")
	public String testReqest(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
	
		
			String testStr = sampleService.getForDatabaseTest();
			log.info("testReqest request start");
			
			model.addAttribute("title", "sampleView");
			model.addAttribute("name", "jys");
			model.addAttribute("dbResult", testStr);

			return "sample/sampleView";
		
	}
	
}
