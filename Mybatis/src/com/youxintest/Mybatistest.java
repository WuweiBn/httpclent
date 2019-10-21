package com.youxintest;

import static org.junit.Assert.*;

import java.util.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.TransactionIsolationLevel;
import org.junit.Test;

import com.unxin.EmployeeMapper;
import com.unxin.roboteMapper;
import com.youxinjr.Employ;
import com.youxinjr.robote;

public class Mybatistest {

	/**
	 * 1,根据xml配置文件创建一个（全局配置文件）SqlSessionFactory对象
	 */
	
	
	@Test
	public void test() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 获取SqlSession实例，能直接执行已经映射的sql语句
		SqlSession openSession = sqlSessionFactory.openSession();
		
		try {
		Employ employ  = openSession.selectOne("com.youxin.mabatis.EmployeeMapper.selectEmp", 3);
		System.out.println(employ);
		}finally {
			openSession.close();
		}
		
	}
	
	/**
	 * 通过接口实习增删改查
	 * */
	@Test
	public void test01() throws IOException {

		// 1,获取SqlsessionFactory对象
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 2,获取SqlSession对象
		SqlSession openSession = sqlSessionFactory.openSession();

		try {
			// 3,获取接口的实现类对象
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);

			Employ employ = mapper.getEmpById(2);

			System.out.println(employ);
		} finally {
			openSession.close();
		}

	}
	
	@Test
	public void test02() throws IOException {
		// 1,获取SqlsessionFactory对象
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 2,获取SqlSession对象
		SqlSession openSession = sessionFactory.openSession();
		
		try {
			// 3,获取接口的实现类对象
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			
			//查询
//			Employ employ = mapper.getEmpById(2);
			
			//添加
//				Employ employ = new Employ( null, 1, "ABCD", "I Love You", "你好", "谢谢");
//				mapper.addEmp(employ);
			
			//更新
//			Employ employ = new Employ(30, 2, "ABCD", "I Love You", "你好", "谢谢");
//			mapper.updateEmp(employ);
				
			//删除
//			 mapper.deleteEmpById(30);

			//多查询
			Employ employ = mapper.getEmpByIdandCod(33, "ABCD");
					
			System.out.println(employ);
			openSession.commit();
			
		} finally {
			openSession.close();
		}

	}
		
	@Test
	public void test03() throws IOException {

		// 1,获取SqlsessionFactory对象
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 2,获取SqlSession对象
		SqlSession openSession = sessionFactory.openSession();

		try {
			// 3,获取接口的实现类对象
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);

			// 模糊查询
			
//			List<Employ> like = mapper.getEmpbylikecode("%A%");
//			for(Employ e :like) {
//			System.out.println(e);
//			}

//			List<Employ> employs = openSession.selectList("com.unxin.EmployeeMapper.getEmpbylikecode", "A");
//			for (Employ e : employs) {
//				System.out.println(e);
//			}
			
//			Map<String, Employ> map = mapper.getBycodeReturnMap("%A%");
//				System.out.println(map);
			
			Employ employ = mapper.getByid(1);
			System.out.println(employ);
			
			openSession.commit();

		} finally {
			openSession.close();
		}

	}

	@Test
	public void test04()throws IOException{
		
		// 1,获取SqlsessionFactory对象
				String resource = "mybatis-config.xml";
				InputStream inputStream = Resources.getResourceAsStream(resource);
				SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
				// 2,获取SqlSession对象
				SqlSession openSession = sessionFactory.openSession();
				
				try {
						 
					EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);

					
						//级联查询1（联合查询）
//						Employ employ = mapper.getrobot(2);
						
						//分布查询(联查拆开查)
						Employ employ = mapper.getroBot(2);
						
						System.out.println(employ);
						System.out.println(employ.getIvr_task_batch());
						
						openSession.commit();
					
				} finally {
					openSession.close();
				}
	}
	
	@Test
	public void test05() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sessionFactory.openSession();

		try {

			roboteMapper mapper = openSession.getMapper(roboteMapper.class);
			robote robote = mapper.getByrobotplus(2);
			System.out.println(robote);
			System.out.println(robote.getEmploys());
			openSession.commit();

		} finally {
			openSession.close();
		}

	}
	
	@Test
	public void test06() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sessionFactory.openSession();
		
		try {
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			List<Employ> list = new ArrayList<>();
//			list.add(new Employ(null, 1, "css", "ffwq", "weq", "fewww", new robote(5)) );
//			list.add(new Employ(null, 1, "21cs", "ffcs", "few", "fwef", new robote(10)) );
			list.add(new Employ(null, 1, "css", "ffwq", "weq", "fewww") );
			list.add(new Employ(null, 1, "21cs", "ffcs", "few", "fwef") );
			mapper.addEmpss(list);
			openSession.commit();
		} finally {
		openSession.close();
		}
	}
	
	
	
	
}