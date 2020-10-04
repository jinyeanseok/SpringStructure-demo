package net.eduSample.sample.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;
import net.eduSample.common.vo.UserVO;
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

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET() throws Exception {
		log.info("registerGET");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(UserVO vo, RedirectAttributes ra) throws Exception {
		log.info("registerPOST");
		sampleService.register(vo);
		ra.addFlashAttribute("result", "registerOK");
//		return "redirect:/sample/register";
		return "redirect:/login/form";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGET() throws Exception {
		log.info("get login");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPOST(UserVO vo, HttpServletRequest req, RedirectAttributes ra) throws Exception {
		log.info("post login");

		HttpSession session = req.getSession();

		UserVO login = sampleService.login(vo);

		if (login == null) {
			session.setAttribute("user", null);
			ra.addFlashAttribute("result", "loginFalse");
		} else {
			session.setAttribute("user", login);
			ra.addFlashAttribute("result", "loginOK");
		}
		return "redirect:/";
	}

}
