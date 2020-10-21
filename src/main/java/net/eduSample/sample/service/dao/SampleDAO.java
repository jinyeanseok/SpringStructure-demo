package net.eduSample.sample.service.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import net.eduSample.common.service.dao.BaseDAO;
import net.eduSample.common.vo.BoardVO;
import net.eduSample.common.vo.HistoryVO;
import net.eduSample.common.vo.UserVO;


@Repository("SampleDAO")
public class SampleDAO {
	
	@Resource(name = "BaseDAO")
	private BaseDAO baseDAO;
	
	public String getForDatabaseTest(){
		return (String) baseDAO.selectObject("sampleMapper.selectTest", "");
	}
	
	public void register(UserVO vo) throws Exception {
		baseDAO.insert("userMapper.register", vo);
	}
//	public void register(UserVO vo) throws Exception {
//		baseDAO.insert("userMapper.register");
//	}
	
	public UserVO login(UserVO vo) throws Exception {
		return (UserVO)baseDAO.selectObject("userMapper.login", vo);
	}
	
	public void modify(UserVO vo) throws Exception {
		baseDAO.update("userMapper.modify", vo);
	}
	
	public void delete(UserVO vo) throws Exception {
		baseDAO.delete("userMapper.delete", vo);
	}
	
	public List<UserVO> userAll() throws Exception {
		return (List<UserVO>)baseDAO.selectList("userMapper.userAll", "");
	}
	
	public UserVO userRead(String identification) throws Exception {
		return (UserVO) baseDAO.selectObject("userMapper.userRead", identification);
	}
	
	public UserVO userInfo(String userID) throws Exception {
		return (UserVO)baseDAO.selectObject("userMapper.userInfo", userID);
	}
	
	//Board
	
	public void BoardRegister(BoardVO board) throws Exception {
		baseDAO.insert("BoardMapper.create", board);
	}
	
	public BoardVO read(Integer board_number) throws Exception {
		return (BoardVO)baseDAO.selectObject("BoardMapper.read", board_number);
	}
	
	public void BoardUpdate(BoardVO board) throws Exception {
		baseDAO.update("BoardMapper.Boardupdate", board);
	}
	
	public void BoardDelete(Integer board_number) throws Exception {
		baseDAO.delete("BoardMapper.Boarddelete", board_number);
	}
	
	public List<BoardVO> listAll() throws Exception {
		return (List<BoardVO>)baseDAO.selectList("BoardMapper.listAll", "");
	}
	
	
	// history
	
	public void Hist_register(HistoryVO hist) throws Exception {
		baseDAO.insert("histMapper.Hist_register", hist);
	}
	
	public void Hist_modify(HistoryVO hist) throws Exception {
		baseDAO.update("histMapper.Hist_modify", hist);
	}
	
	
}