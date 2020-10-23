package net.eduSample.sample.service;

import java.util.List;

import net.eduSample.common.vo.BoardVO;
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

	// Board

	public void BoardRegister(BoardVO board) throws Exception;

	public BoardVO read(Integer board_number) throws Exception;

	public void BoardUpdate(BoardVO board) throws Exception;

	public void BoardDelete(Integer board_number) throws Exception;

	public List<BoardVO> listAll() throws Exception;

	// hist user
	public UserVO login_hist(UserVO vo) throws Exception;

	// hist
	public UserVO logout_hist(UserVO vo) throws Exception;

	// hist
	public void modify_hist(UserVO vo) throws Exception;

	// hist
	public void delete_hist(UserVO vo) throws Exception;

	// hist board
	public void BoardRegister_hist(BoardVO board) throws Exception;

	// hist
	public BoardVO read_hist(BoardVO board) throws Exception;

	// hist
	public void BoardUpdate_hist(BoardVO board) throws Exception;

	// hist
	public void BoardDelete_hist(BoardVO board) throws Exception;
	//
	// // hist
	// public void BoardUpdate_hist(BoardVO board) throws Exception;
	//
	// // hist
	// public void BoardDelete_hist(Integer board_number) throws Exception;
	//
	// // hist
	// public List<BoardVO> listAll_hist() throws Exception;
}
