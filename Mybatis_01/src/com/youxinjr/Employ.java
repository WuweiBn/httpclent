package com.youxinjr;

public class Employ {

	private Integer id;
	private int robot_id;
	private String code;
	private String state;
	private String remark;
	private String additional_desc; 
	private robote  ivr_task_batch;



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getRobot_id() {
		return robot_id;
	}

	public void setRobot_id(int robot_id) {
		this.robot_id = robot_id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAdditional_desc() {
		return additional_desc;
	}

	public void setAdditional_desc(String additional_desc) {
		this.additional_desc = additional_desc;
	}
	
	public robote getIvr_task_batch() {
		return ivr_task_batch;
	}

	public void setIvr_task_batch(robote ivr_task_batch) {
		this.ivr_task_batch = ivr_task_batch;
	}
	

	public Employ(Integer id, int robot_id, String code, String state, String remark, String additional_desc) {
		super();
		this.id = id;
		this.robot_id = robot_id;
		this.code = code;
		this.state = state;
		this.remark = remark;
		this.additional_desc = additional_desc;
	}

	public Employ() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employ [id=" + id + ", robot_id=" + robot_id + ", code=" + code + ", state=" + state + ", remark="
				+ remark + ", additional_desc=" + additional_desc + "]";
	}

	
}
