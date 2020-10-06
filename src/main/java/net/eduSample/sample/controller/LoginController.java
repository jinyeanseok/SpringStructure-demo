package net.eduSample.sample.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.eduSample.common.vo.UserVO;
import net.eduSample.sample.service.SampleService;

@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {

	@Resource(name = "SampleService")
	private SampleService sampleService;
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String login() {
//		return "login/ajax_client";
		return "pages/login";
	}
	
	@RequestMapping(value="/pwdFind", method=RequestMethod.GET) // href="/login/pwdFind"시  pages/forgot-password로 이동
	public String password() {
		return "pages/forgot-password";
	}
	
	
//	@RequestMapping(value="/proc", method=RequestMethod.POST)
//	@ResponseBody
//	public Map<String, Boolean> login(UserVO user) {
//		
//		// �α��� ����� json ���ڿ��� Ŭ���̾�Ʈ���� ����
//		boolean result = false;
//		Map<String, Boolean> map = new HashedMap<String, Boolean>();
//		if(user==null || user.getIdentification().equals("") || user.getPassword().equals("")) {
//			result = false;
//		} else {
//			result = true;
//		}
//		map.put("result", result);
//		return map;
//		// �䰡 ����Ǵ� ���� �ƴ϶� ���� �����Ϳ� �ش��ϴ� ��ü�� ����
//	}
	
//	@RequestMapping(value="/proc", method=RequestMethod.POST)
//	@ResponseBody
//	public Map<String, Boolean> login(UserVO vo, HttpServletRequest req) {
//		try {
//			HttpSession session = req.getSession();
//			
//			UserVO login = sampleService.login(vo);
//			// �α��� ����� json ���ڿ��� Ŭ���̾�Ʈ���� ����
//			boolean result = false;
//			Map<String, Boolean> map = new HashedMap<String, Boolean>();
//			if(vo==null || !(vo.getIdentification().equals(login.getIdentification())) || !(vo.getPassword().equals(login.getPassword()))) {
//				result = false;
//				session.setAttribute("user", null);
//			} else {
//				result = true;
//				session.setAttribute("user", login);
//			}
//			map.put("result", result);
//			return map;
//			// �䰡 ����Ǵ� ���� �ƴ϶� ���� �����Ϳ� �ش��ϴ� ��ü�� ����
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	@RequestMapping(value="/proc", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> login(UserVO vo, HttpServletRequest req) {
		Map<String, Boolean> map = new HashedMap<String, Boolean>();
		try {
			HttpSession session = req.getSession();
			UserVO login = sampleService.login(vo);
			boolean result = false;
			if(login.getPassword().equals(vo.getPassword())) {
				result = true;
				session.setAttribute("user", login);
			} else {
				result = false;
				session.setAttribute("user", null);
			}
			map.put("result", result);
			return map;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return map;
	}
	

}
