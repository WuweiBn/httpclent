package com.unxin;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.youxinjr.user_compensatory_summary;

public interface EmployeeMapperDTsql {
	
	public  List<user_compensatory_summary> getByapplyid(user_compensatory_summary user_compensatory_summary);
	
	public  List<user_compensatory_summary> getByapplyidtrim(user_compensatory_summary user_compensatory_summary);
	
	public void getByapplyidupdate(user_compensatory_summary user_compensatory_summary);
	
	public List<user_compensatory_summary>getapplyidIn(@Param("applyids") List<Integer> user_compensatory_summary);
	
	public void  getinster(@Param("user")List<user_compensatory_summary>  user);

}
