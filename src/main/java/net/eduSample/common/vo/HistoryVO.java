package net.eduSample.common.vo;

import java.util.Date;

public class HistoryVO {

	// user
	private String identification;
	private String password;
	private String name;
	private Date create_date;
	private Date update_date;
	private int verify;
	// board
	private Integer board_number;
	private String title;

	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	public int getVerify() {
		return verify;
	}
	public void setVerify(int verify) {
		this.verify = verify;
	}
	public Integer getBoard_number() {
		return board_number;
	}
	public void setBoard_number(Integer board_number) {
		this.board_number = board_number;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
