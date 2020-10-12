package net.eduSample.sample.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.eduSample.common.vo.BoardVO;
import net.eduSample.common.vo.HistoryVO;
import net.eduSample.common.vo.UserVO;
import net.eduSample.sample.service.SampleService;
import net.eduSample.sample.service.dao.SampleDAO;

@Service("SampleService")
public class SampleServiceImpl implements SampleService {

	@Resource(name = "SampleDAO")
	private SampleDAO sampleDAO;

	public String getForDatabaseTest() throws Exception {

		return sampleDAO.getForDatabaseTest();
	}

	@Override
	public void register(UserVO vo) throws Exception {
		sampleDAO.register(vo);
	}

	@Override
	public UserVO login(UserVO vo) throws Exception {
		return sampleDAO.login(vo);
	}

	@Override
	public void modify(UserVO vo) throws Exception {
		sampleDAO.modify(vo);
	}

	@Override
	public void delete(UserVO vo) throws Exception {
		sampleDAO.delete(vo);
	}

	@Override
	public List<UserVO> userAll() throws Exception {
		return (List<UserVO>) sampleDAO.userAll();
	}

	@Override
	public UserVO userRead(String identification) throws Exception {
		return (UserVO) sampleDAO.userRead(identification);
	}
	
	public UserVO userInfo(String userID) throws Exception {
		return (UserVO) sampleDAO.userInfo(userID);
	}

	// Board
	@Override
	public void BoardRegister(BoardVO board) throws Exception {
		sampleDAO.BoardRegister(board);
	}

	@Override
	public BoardVO read(Integer board_number) throws Exception {
		return (BoardVO) sampleDAO.read(board_number);
	}

	@Override
	public void BoardUpdate(BoardVO board) throws Exception {
		sampleDAO.BoardUpdate(board);
	}

	@Override
	public void BoardDelete(Integer board_number) throws Exception {
		sampleDAO.BoardDelete(board_number);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return (List<BoardVO>) sampleDAO.listAll();
	}

	@Override
	public void Hist_register(HistoryVO hist) throws Exception {
		sampleDAO.Hist_register(hist);
	}

	@Override
	public void Hist_modify(HistoryVO hist) throws Exception {
		sampleDAO.Hist_modify(hist);
	}
	
}
