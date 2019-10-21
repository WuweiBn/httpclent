package com.youxinjr;

import java.util.Date;

public class user_compensatory_summary {
	
	 	private Integer id;
	 
	    private Integer applyid;

	    private Integer fund_channel ;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Integer getApplyid() {
			return applyid;
		}

		public void setApplyid(Integer applyid) {
			this.applyid = applyid;
		}

		public Integer getFund_channel() {
			return fund_channel;
		}

		public void setFund_channel(Integer fund_channel) {
			this.fund_channel = fund_channel;
		}

		public user_compensatory_summary(Integer id, Integer applyid, Integer fund_channel) {
			super();
			this.id = id;
			this.applyid = applyid;
			this.fund_channel = fund_channel;
		}

		public user_compensatory_summary() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "user_compensatory_summary [id=" + id + ", applyid=" + applyid + ", fund_channel=" + fund_channel
					+ "]";
		}

		
}