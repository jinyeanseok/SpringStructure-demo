package net.eduSample.common.vo;

import java.util.Date;

public class UserVO {
	
	private Integer user_number;
	private String identification;
	private String password;
	private String name;
	private Date create_date;
	private Date update_date;
	private int verify;

	public int getVerify() {
		return verify;
	}

	public void setVerify(int verify) {
		this.verify = verify;
	}

	
	public Integer getUser_number() {
		return user_number;
	}

	public void setUser_number(Integer user_number) {
		this.user_number = user_number;
	}

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
	
}
