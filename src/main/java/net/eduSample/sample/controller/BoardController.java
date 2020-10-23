package net.eduSample.sample.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
@RequestMapping(value = "/board/")
@Slf4j
public class BoardController {

	private static final Log LOG = LogFactory.getLog(BoardController.class);

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
	public void registerGET(BoardVO board) throws Exception {
		log.info("register GET !!");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(BoardVO board, RedirectAttributes ra) throws Exception {
		log.info("register POST !!");
		sampleService.BoardRegister(board);
		ra.addFlashAttribute("result", "Board_registerOK");
		return "redirect:/board/listAll";
	}

	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(ModelMap model) throws Exception {
		log.info("listAll!!");
		LOG.debug("#ex1 - debug log");
		LOG.info("#ex1 - info log");
		LOG.warn("#ex1 - warn log");
		LOG.error("#ex1 - error log");
		List<BoardVO> boards = sampleService.listAll();
		model.addAttribute("list", boards);
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("board_number") Integer board_number, HttpSession session, ModelMap model)
			throws Exception {
		// 페이지 목록 유지를 위해 사용되고 있는 page, perPageNum 값 가져오기
		log.info("read GET!!!");
		BoardVO board = sampleService.read(board_number);

		UserVO user = (UserVO) session.getAttribute("user"); // hist table 용
		log.info("글 번호 : " + board_number);
		Integer key = user.getUser_number();
		
		board.setUser_number(key);
		board.setComment("글 보기");
		board.setBoard_number(board_number);
		sampleService.read_hist(board);
		// setter로 board_number 값 보내주고

		model.addAttribute("BoardVO", board);
		log.info(board.toString());
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public void updateGET(@RequestParam("board_number") Integer board_number, ModelMap model) throws Exception {
		log.info("updateGET!!!");
		BoardVO board = sampleService.read(board_number);
		model.addAttribute("BoardVO", board);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatePOST(BoardVO board, HttpSession session, @RequestParam("board_number") Integer board_number, RedirectAttributes ra)
			throws Exception {
		log.info("updateGET!!!");
		sampleService.BoardUpdate(board);
		UserVO user = (UserVO) session.getAttribute("user"); // hist table 용
		Integer key = user.getUser_number();
		board.setUser_number(key);
		board.setComment("글 수정");
		board.setBoard_number(board_number);
		sampleService.BoardUpdate_hist(board);
		ra.addFlashAttribute("result", "updateOK");
		return "redirect:/board/read?board_number=" + board_number;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public void deleteGET(@RequestParam("board_number") Integer board_number, ModelMap model) throws Exception {
		log.info("deleteGET");
		BoardVO board = sampleService.read(board_number);
		model.addAttribute("BoardVO", board);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deletePOST(@RequestParam("board_number") Integer board_number, BoardVO board, HttpSession session, RedirectAttributes ra)
			throws Exception {
		log.info("deletePOST");
		sampleService.BoardDelete(board_number);
		UserVO user = (UserVO) session.getAttribute("user"); // hist table 용
		Integer key = user.getUser_number();
		board.setUser_number(key);
		board.setComment("글 삭제");
		board.setBoard_number(board_number);
		sampleService.BoardDelete_hist(board);
		ra.addFlashAttribute("result", "Board_deleteOK");
		return "redirect:/board/listAll";
	}

}
