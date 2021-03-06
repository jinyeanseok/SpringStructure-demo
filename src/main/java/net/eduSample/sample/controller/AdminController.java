	package net.eduSample.sample.controller;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
@RequestMapping(value = "/admin/")
@Slf4j
public class AdminController {

	@RequestMapping(value = "/index", method=RequestMethod.GET)
	public void idex() throws Exception {
		log.info("index Page");
	}
	
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
	public void registerGET(BoardVO board) throws Exception {
		log.info("register GET !!");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(BoardVO board, RedirectAttributes ra) throws Exception {
		log.info("register POST !!");
		
		sampleService.BoardRegister(board);
		
		ra.addFlashAttribute("result", "Board_registerOK");
		return "redirect:/admin/listAll";
	}
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(ModelMap model) throws Exception {
		log.info("listAll!!");
		List<BoardVO> boards = sampleService.listAll();
		model.addAttribute("list", boards);
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("board_number") Integer board_number, ModelMap model) throws Exception{
		 // 페이지 목록 유지를 위해 사용되고 있는 page, perPageNum 값 가져오기
		 log.info("read GET!!!");
		 BoardVO board = sampleService.read(board_number);
		 model.addAttribute("BoardVO",board);
		 log.info(board.toString());
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public void updateGET(@RequestParam("board_number") Integer board_number, ModelMap model) throws Exception {
		log.info("updateGET!!!");
		BoardVO board = sampleService.read(board_number);
		 model.addAttribute("BoardVO",board);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatePOST(BoardVO board, @RequestParam("board_number") Integer board_number, RedirectAttributes ra) throws Exception {
		log.info("updateGET!!!");
		sampleService.BoardUpdate(board);
		ra.addFlashAttribute("result", "updateOK");
		return "redirect:/admin/read?board_number="+board_number;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public void deleteGET(@RequestParam("board_number") Integer board_number, ModelMap model) throws Exception {
		log.info("deleteGET");
		BoardVO board = sampleService.read(board_number);
		model.addAttribute("BoardVO", board);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deletePOST(@RequestParam("board_number") Integer board_number, RedirectAttributes ra) throws Exception {
		log.info("deletePOST");
		sampleService.BoardDelete(board_number);
		ra.addFlashAttribute("result", "Board_deleteOK");
		return "redirect:/admin/listAll";
	}
	
	
	// 관리자 계정 생성
	@RequestMapping(value = "/admin_register", method = RequestMethod.GET)
	public void registerGET() throws Exception {
		log.info("registerGET");
	}

	@RequestMapping(value = "/admin_register", method = RequestMethod.POST)
	public String registerPOST(UserVO vo, RedirectAttributes ra) throws Exception {
		log.info("registerPOST");
		sampleService.register(vo);
		ra.addFlashAttribute("result", "registerOK");
//		return "redirect:/login/form";
		return "redirect:/admin/listAll";
	}

}
