package net.eduSample.sample.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

	// aop TEST 메서드
	// @Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class}) 적용됨
	@Transactional(rollbackFor = { Exception.class })
	@Override
	public void register(UserVO vo) throws Exception {
		try {
			sampleDAO.register(vo);
//			BoardVO board = new BoardVO();
//			board.setBoard_number(1);
//			board.setTitle("transaction TEST");
//			sampleDAO.BoardUpdate(board);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(); // Spring에 던져준다 (이거 있어야 rollback 처리됨)
		}
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

	@Override
	public void BoardRegister(BoardVO board) throws Exception {
		sampleDAO.BoardRegister(board);
	}

	@Override
	public BoardVO read(Integer board_number) throws Exception {
		return (BoardVO) sampleDAO.read(board_number);
	}

	// @Transactional(rollbackFor = DataAccessException.class)
	@Override
	public void BoardUpdate(BoardVO board) throws Exception {
		// sampleDAO.BoardUpdate(board);
		// ROLLBACK
		// 특수문자가 있으면 EXCEPTION

		// 히스토리 인서트
		sampleDAO.BoardUpdate(board);
		// throw new Exception(); // Spring에 던져준다

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
