package net.eduSample.common.vo;

import java.util.Date;

public class BoardVO {
	private Integer board_number;
	private Integer user_number;
	private String title;
	private String identification;
	private Date create_date;
	private String comment;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getBoard_number() {
		return board_number;
	}

	public void setBoard_number(Integer board_number) {
		this.board_number = board_number;
	}

	public Integer getUser_number() {
		return user_number;
	}

	public void setUser_number(Integer user_number) {
		this.user_number = user_number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
}
