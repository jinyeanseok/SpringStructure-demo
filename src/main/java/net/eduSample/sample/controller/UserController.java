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
import net.eduSample.common.vo.HistoryVO;
import net.eduSample.common.vo.UserVO;
import net.eduSample.sample.service.SampleService;

@Controller
@RequestMapping(value = "/user/")
@Slf4j
public class UserController {

	@Resource(name = "SampleService")
	private SampleService sampleService;

	@RequestMapping(value = "/testRequest")
	public String testReqest(HttpServletRequest request, HttpServletResponse response, ModelMap model)
			throws Exception {

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
	public String registerPOST(UserVO vo, HistoryVO hist, RedirectAttributes ra) throws Exception {
		log.info("registerPOST");
		sampleService.register(vo);
		// sampleService.Hist_modify(hist); // hist table
		ra.addFlashAttribute("result", "registerOK");
		// return "redirect:/login/form";
		return "redirect:/board/listAll";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET() throws Exception {
		log.info("modify GET");
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(UserVO vo, HttpSession session, RedirectAttributes ra) throws Exception {
		log.info("modify POST");
		System.out.println("vo : " + vo.getIdentification());
		System.out.println("vo : " + vo.getPassword());
		sampleService.modify(vo);
		session.invalidate();
		ra.addFlashAttribute("result", "modifyOK");
		return "redirect:/login/form";
	}

	// 관리자 전용 modify
	@RequestMapping(value = "/modify_admin", method = RequestMethod.GET)
	public void modifyAdminGET(UserVO vo, @RequestParam("identification") String identification, ModelMap model)
			throws Exception {
		log.info("modify GET");
		System.out.println("modify test : " + vo.getIdentification());
		model.addAttribute("UserVO", vo);
	}

	// 관리자 전용 modify
	@RequestMapping(value = "/modify_admin", method = RequestMethod.POST)
	public String modifyAdminPOST(UserVO vo, HttpSession session, RedirectAttributes ra) throws Exception {
		log.info("modify POST");
		System.out.println("vo : " + vo.getIdentification());
		System.out.println("vo : " + vo.getPassword());
		sampleService.modify(vo);
		// session.invalidate(); 관리자가 다른 사람의 정보를 변경할 때는 세션을 끊을 필요가없다.
		ra.addFlashAttribute("result", "modifyOK");
		return "redirect:/user/userAll";
	}

	// 관리자 권한의 modify 메서드와 사용자 입장에서의 modify 메서드를 만들어보자

	@RequestMapping(value = "/dashBoard", method = RequestMethod.GET)
	public String dashBoard() throws Exception {
		return "sample/dashBoard";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session, RedirectAttributes ra) throws Exception {
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

		UserVO user = (UserVO) session.getAttribute("user");
		System.out.println("시용자의 아이디 : " + vo.getIdentification());
		System.out.println("시용자의 비밀번호 : " + vo.getPassword());

		String oldPass = user.getPassword();
		String newPass = vo.getPassword();

		if (oldPass.equals(newPass)) {
			sampleService.delete(vo);
			session.invalidate();
			ra.addFlashAttribute("result", "deleteOK");
		}
		return "redirect:/board/listAll";
	}

	@RequestMapping(value = "/delete_admin", method = RequestMethod.GET)
	public void deleteAdminGET() throws Exception {
		log.info("delete GET!!");
	}

	@RequestMapping(value = "/delete_admin", method = RequestMethod.POST)
	public String deleteAdminPOST(UserVO vo, HttpSession session, RedirectAttributes ra) throws Exception {
		log.info("delete POST!!");

		String userID = vo.getIdentification();
		UserVO userPW = sampleService.userInfo(userID);
		
		System.out.println("입력한 사용자의 비밀번호 : " + vo.getPassword());
		System.out.println("관리자가 삭제할 사용자의 비밀번호 : " + userPW.getPassword());

		if (userPW.getPassword().equals(vo.getPassword())) {
			sampleService.delete(vo);
			System.out.println("아이디 = " + vo.getIdentification() + "," + "비밀번호 = " + vo.getPassword());
			ra.addFlashAttribute("result", "deleteOK");
			return "redirect:/user/userAll";
		}
		ra.addFlashAttribute("result", "deleteNO");
		return "redirect:/user/userAll";

	}

	@RequestMapping(value = "/userAll", method = RequestMethod.GET)
	public void userAll(ModelMap model) throws Exception {
		log.info("userAll!!");
		List<UserVO> users = sampleService.userAll();
		model.addAttribute("list", users);
	}

	@RequestMapping(value = "/userRead", method = RequestMethod.GET)
	public void userRead(@RequestParam("identification") String identification, ModelMap model) throws Exception {
		log.info("userRead GET!!!");
		UserVO users = sampleService.userRead(identification);
		model.addAttribute("UserVO", users);
		log.info(users.toString());
		// jenkins TEST 1
		
	}	
}
