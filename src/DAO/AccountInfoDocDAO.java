package DAO;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import pojo.Account;

public class AccountInfoDocDAO {
	public SqlSession getSession() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory.openSession();
	}

	public Account getAccount(String id) throws IOException {
		SqlSession sqlSession = getSession();
		Account resAccount = sqlSession.selectOne("getAccount", id);
		sqlSession.close();
		return resAccount;
	}

	public boolean isIdExisting(String id) throws IOException {
		if (getAccount(id) == null) {
			return false;
		} else {
			return true;
		}
	}

	public boolean addAccount(Account account) throws IOException {
		SqlSession sqlSession = getSession();
		try {
			sqlSession.insert("addAccount", account);
			sqlSession.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			sqlSession.close();
		}
	}

	public boolean updateAccountPw(Account account) throws IOException {
		SqlSession sqlSession = getSession();
		try {
			sqlSession.update("updateAccountPw", account);
			sqlSession.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			sqlSession.close();
		}
	}

	public boolean updateAccount(Map<String, String> newAccountInfo) throws IOException {
		SqlSession sqlSession = getSession();
		try {
			sqlSession.update("updateAccount", newAccountInfo);
			sqlSession.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			sqlSession.close();
		}
	}

	public boolean deleteAccount(String id) throws IOException {
		SqlSession sqlSession = getSession();
		if (!isIdExisting(id)) {
			return false;
		} else {
			try {
				sqlSession.delete("deleteAccount", id);
				sqlSession.commit();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			} finally {
				sqlSession.close();
			}
		}
	}

//	public static void main(String args[]) throws IOException {
//		AccountInfoDocDAO aidDAO = new AccountInfoDocDAO();
//		// Account a =new Account();
//		// a.setId("t");
//		// a.setPassword("t1");
//		// a.setContactInfo("fd");
//		
////		Map<String, String> map = new HashMap<>();
////		map.put("newId", "ttt_new");
////		map.put("formerId", "ttt");
////		map.put("contactInfo", "ttt@_new");
////		map.put("password", "ttt_new");
////		System.out.println(aidDAO.updateAccount(map));
//	}
//
}
