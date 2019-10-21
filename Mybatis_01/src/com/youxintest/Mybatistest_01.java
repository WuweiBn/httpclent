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
import com.unxin.EmployeeMapperDTsql;
import com.unxin.roboteMapper;
import com.youxinjr.Employ;
import com.youxinjr.robote;
import com.youxinjr.user_compensatory_summary;

public class Mybatistest_01 {

	/**
	 * 1,根据xml配置文件创建一个（全局配置文件）SqlSessionFactory对象
	 * 
	 * @return
	 * @throws IOException
	 */

	public SqlSessionFactory getSqlSessionFactory() throws IOException {

		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sessionFactory;

	}

	@Test
	public void test01() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();

		try {

			EmployeeMapperDTsql mapper = openSession.getMapper(EmployeeMapperDTsql.class);
			user_compensatory_summary user_compensatory_summary = new user_compensatory_summary(2, 1245567866, 1);

			// 测试if
//			List<com.youxinjr.user_compensatory_summary> emps = mapper.getByapplyid(user_compensatory_summary);
//			for (user_compensatory_summary e : emps) {
//				System.out.println(e);
//			}

			// 测试trim
//			List<com.youxinjr.user_compensatory_summary> emps2 = mapper.getByapplyidtrim(user_compensatory_summary);
//			for (user_compensatory_summary e2 : emps2) {
//				System.out.println(e2);
//			}

			// 测试更新传哪个改哪个值
//			mapper.getByapplyidupdate(user_compensatory_summary);

			List<user_compensatory_summary> list = mapper.getapplyidIn(Arrays.asList(3454355, 1502056, 3582890));
			for (user_compensatory_summary e : list) {
				System.out.println(e);

			}

			openSession.commit();

		} finally {
			openSession.close();
		}

	}

	@Test
	public void test02() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			EmployeeMapperDTsql mapper = openSession.getMapper(EmployeeMapperDTsql.class);

			List<user_compensatory_summary> ucm = new ArrayList<>();
			ucm.add(new user_compensatory_summary(null, 151112, 1));
			ucm.add(new user_compensatory_summary(null, 151113, 10));
			// 若是不同表中添加需要继续new出
//				ucm.add(new user_compensatory_summary(null, 151112, 10, new Depament(1));
			mapper.getinster(ucm);

			openSession.commit();

		} finally {
			openSession.close();
		}
	}

}