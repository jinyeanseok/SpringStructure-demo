package net.eduSample.sample.service;

import java.util.List;

import net.eduSample.common.vo.BoardVO;
import net.eduSample.common.vo.HistoryVO;
import net.eduSample.common.vo.UserVO;

public interface SampleService {
	
	public String getForDatabaseTest() throws Exception;
	
	public void register(UserVO vo) throws Exception;
	
	public UserVO login(UserVO vo) throws Exception;
	
	public void modify(UserVO vo) throws Exception;
	
	public void delete(UserVO vo) throws Exception;
	
	public List<UserVO> userAll() throws Exception;
	
	public UserVO userRead(String identification) throws Exception;
	
	public UserVO userInfo(String userID) throws Exception;
	
	//Board
	
	public void BoardRegister(BoardVO board) throws Exception;
	
	public BoardVO read(Integer board_number) throws Exception;
	
	public void BoardUpdate(BoardVO board) throws Exception;
	
	public void BoardDelete(Integer board_number) throws Exception;
	
	public List<BoardVO> listAll() throws Exception;
	
	//hist
	
	public void Hist_register(HistoryVO hist) throws Exception;
	
	public void Hist_modify(HistoryVO hist) throws Exception;
}
