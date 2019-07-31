package com.qa.data;

public class Msg {
	
	private  int[] Applyids ;
	private  String  p;
	private int postloanType;
	

	public Msg(int[] applyids, String p, int postloanType) {
		super();
		Applyids = applyids;
		this.p = p;
		this.postloanType = postloanType;
	}


	public int[] getApplyids() {
		return Applyids;
	}


	public void setApplyids(int[] applyids) {
		Applyids = applyids;
	}


	public String getP() {
		return p;
	}


	public void setP(String p) {
		this.p = p;
	}


	public int getPostloanType() {
		return postloanType;
	}


	public void setPostloanType(int postloanType) {
		this.postloanType = postloanType;
	}


	public Msg() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

}
