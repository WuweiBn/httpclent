package com.youxinjr;

import java.util.List;

public class robote {
	
	private Integer id;
	private  Integer user_id;
	private  int is_cancel;
	private int robot_id;
	private List<Employ>employs;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public int getIs_cancel() {
		return is_cancel;
	}
	public void setIs_cancel(int is_cancel) {
		this.is_cancel = is_cancel;
	}
	public int getRobot_id() {
		return robot_id;
	}
	public void setRobot_id(int robot_id) {
		this.robot_id = robot_id;
	}
	public List<Employ> getEmploys() {
		return employs;
	}
	public void setEmploys(List<Employ> employs) {
		this.employs = employs;
	}
	
	


	public robote(int robot_id) {
		super();
		this.robot_id = robot_id;
	}
	public robote() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "robote [id=" + id + ", user_id=" + user_id + ", is_cancel=" + is_cancel + ", robot_id=" + robot_id
				+ ", employs=" + employs + ", getId()=" + getId() + ", getUser_id()=" + getUser_id()
				+ ", getIs_cancel()=" + getIs_cancel() + ", getRobot_id()=" + getRobot_id() + ", getEmploys()="
				+ getEmploys() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
