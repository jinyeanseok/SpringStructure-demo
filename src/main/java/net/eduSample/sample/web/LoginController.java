package net.eduSample.sample.web;

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
		return "login/ajax_client";
	}
	
//	@RequestMapping(value="/proc", method=RequestMethod.POST)
//	@ResponseBody
//	public Map<String, Boolean> login(UserVO user) {
//		
//		// 로그인 결과를 json 문자열로 클라이언트에게 전송
//		boolean result = false;
//		Map<String, Boolean> map = new HashedMap<String, Boolean>();
//		if(user==null || user.getIdentification().equals("") || user.getPassword().equals("")) {
//			result = false;
//		} else {
//			result = true;
//		}
//		map.put("result", result);
//		return map;
//		// 뷰가 연결되는 것이 아니라 응답 데이터에 해당하는 객체를 리턴
//	}
	
//	@RequestMapping(value="/proc", method=RequestMethod.POST)
//	@ResponseBody
//	public Map<String, Boolean> login(UserVO vo, HttpServletRequest req) {
//		try {
//			HttpSession session = req.getSession();
//			
//			UserVO login = sampleService.login(vo);
//			// 로그인 결과를 json 문자열로 클라이언트에게 전송
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
//			// 뷰가 연결되는 것이 아니라 응답 데이터에 해당하는 객체를 리턴
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	@RequestMapping(value="/proc", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> login(UserVO vo, HttpServletRequest req) {
		try {
			HttpSession session = req.getSession();
			
			UserVO login = sampleService.login(vo);
			// 로그인 결과를 json 문자열로 클라이언트에게 전송
			boolean result = false;
			Map<String, Boolean> map = new HashedMap<String, Boolean>();
//			if(vo.equals(login) && vo.getIdentification().equals(login.getIdentification()) && vo.getPassword().equals(login.getPassword())) {
			
			if(vo.getIdentification().equals(login.getIdentification()) && vo.getPassword().equals(login.getPassword())) {
				result = true;
				session.setAttribute("user", login);
			} else {
				result = false;
				session.setAttribute("user", null);
			}
			map.put("result", result);
			return map;
			// 뷰가 연결되는 것이 아니라 응답 데이터에 해당하는 객체를 리턴
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
