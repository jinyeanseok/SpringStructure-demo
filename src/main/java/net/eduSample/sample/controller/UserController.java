package net.eduSample.sample.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;
import net.eduSample.common.vo.BoardVO;
import net.eduSample.common.vo.UserVO;
import net.eduSample.sample.service.SampleService;

@Controller
@RequestMapping(value = "/user/")
@Slf4j
public class UserController {

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
//		return "redirect:/login/form";
		return "redirect:/board/listAll";
	}
	
	// 원본
//	@RequestMapping(value = "/modify", method = RequestMethod.GET)
//	public void modifyGET() throws Exception {
//		log.info("modify GET");
//	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET(UserVO vo, @RequestParam("identification") String identification, ModelMap model, HttpServletRequest req) throws Exception {
		log.info("modify GET");
		System.out.println("modify test : " + vo.getIdentification());
		
		UserVO login = sampleService.login(vo);
		
		if(login.getVerify() != 9) {   // 세션 값 불러와서 user.getVerify하면 될듯
//			UserVO users = sampleService.userRead(identification);
//			model.addAttribute("UserVO", users);
			model.addAttribute("UserVO", login);
		}
	}
	
//	// test용
//			@RequestMapping(value = "/modify", method = RequestMethod.POST)
//			public String modifyPOST(UserVO vo, @RequestParam("identification") String identification, HttpSession session, RedirectAttributes ra, ModelMap model) throws Exception {
//				log.info("modify POST");
//				
//				if(vo.getVerify() == 9) {
//					UserVO users = sampleService.userRead(identification);
//					sampleService.modify(users);
//					log.info("관리자 입장에서의 회원아이디" + users.getIdentification());
//					model.addAttribute("UserVO", users);
//					session.invalidate();
//					ra.addFlashAttribute("result", "modifyOK");
//					return "redirect:/user/userAll";
//				} 
//				sampleService.modify(vo);
//				session.invalidate();
//				ra.addFlashAttribute("result", "modifyOK");
////				return "redirect:/sample/dashBoard";
//				return "redirect:/login/form";
//				// 위와 같이 /로 dashBoard로 보내도 저 경로는 <webcome-file-list>에서 설정했기 때문에 안되는듯 하다.
//			}
	
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
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value = "/userAll", method = RequestMethod.GET)
	public void userAll(ModelMap model) throws Exception {
		log.info("userAll!!");
		List<UserVO> users = sampleService.userAll();
		model.addAttribute("list", users);
	}
	
	@RequestMapping(value = "/userRead", method = RequestMethod.GET)
	public void userRead(@RequestParam("identification") String identification, ModelMap model) throws Exception{
		 // 페이지 목록 유지를 위해 사용되고 있는 page, perPageNum 값 가져오기
		 log.info("userRead GET!!!");
//		 UserVO users = sampleService.read(identification);
		 UserVO users = sampleService.userRead(identification);
		 model.addAttribute("UserVO", users);
		 log.info(users.toString());
	}
	
	
}
