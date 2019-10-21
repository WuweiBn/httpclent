package com.unxin;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.youxinjr.Employ;

public interface EmployeeMapper {
	
	public Employ getroBot (Integer id);
	
	public  Employ getrobot(Integer id);
	
	//返回值为resultMap
	public Employ getByid(Integer id);
	
	//让code做主键
	@MapKey("code")
	public Map<String, Employ> getBycodeReturnMap(String code);
	
	public List<Employ> getEmpbylikecode(String code); 
	
	public Employ getEmpByIdandCod(@Param("id")Integer id,@Param("code")String code);

	public Employ getEmpById(Integer id);

	public void addEmp(Employ employ);


	public void updateEmp(Employ employ);

	public void  deleteEmpById(Integer id);
	
	//批量插入
	public void addEmpss( @Param("emps")List<Employ> emp);

}
