package net.eduSample.sample.controller;

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
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() throws Exception {
		return "sample/dashBoard";
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
//		return "redirect:/login/form";
		return "redirect:/sample/dashBoard";
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
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET() throws Exception {
		log.info("modify GET");
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(UserVO vo, HttpSession session, RedirectAttributes ra) throws Exception {
		log.info("modify POST");
		sampleService.modify(vo);
		session.invalidate();
		ra.addFlashAttribute("result", "modifyOK");
//		return "redirect:/sample/dashBoard";
		return "redirect:/login/form";
		// 위와 같이 /로 dashBoard로 보내도 저 경로는 <webcome-file-list>에서 설정했기 때문에 안되는듯 하다.
	}
	
	@RequestMapping(value = "/dashBoard", method = RequestMethod.GET)
	public String dashBoard() throws Exception {
		return "sample/dashBoard";
	}
	
	@RequestMapping(value ="/logout", method = RequestMethod.GET)
	public String logout(HttpSession session, RedirectAttributes ra ) throws Exception {
		log.info("logout!!");
		ra.addFlashAttribute("result", "logoutOK");
		session.invalidate();
		return "redirect:/login/form";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public void deleteGET() throws Exception {
		log.info("delete GET!!");
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deletePOST(UserVO vo, HttpSession session, RedirectAttributes ra) throws Exception {
		log.info("delete POST!!");
		
		UserVO user = (UserVO)session.getAttribute("user");
		String oldPass = user.getPassword();
		String newPass = vo.getPassword();
		
		if(oldPass.equals(newPass)) {
			sampleService.delete(vo);
			session.invalidate();
			ra.addFlashAttribute("result", "deleteOK");
		}
		return "redirect:/sample/home";
	}
}
