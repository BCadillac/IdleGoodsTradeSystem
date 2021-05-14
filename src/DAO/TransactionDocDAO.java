package DAO;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pojo.Transaction;

public class TransactionDocDAO {
	public SqlSession getSession() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory.openSession();
	}
	public boolean addTransaction(Transaction transaction) throws IOException{
		SqlSession sqlSession =getSession();
		try{
			sqlSession.insert("addTransaction",transaction);
			sqlSession.commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally {
			sqlSession.close();
		}
	}
	public List<Transaction> getMyBroughtTransactions(String buyerId) throws IOException{
		SqlSession sqlSession=getSession();
		try{
			Map<String, String>param=new HashMap<>();
			param.put("buyerId", buyerId);
			return sqlSession.selectList("getTransaction", param);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sqlSession.close();
		}
	}
	public List<Transaction> getMySoldTransactions(String sellerId) throws IOException{
		SqlSession sqlSession=getSession();
		try{
			Map<String, String>param=new HashMap<>();
			param.put("sellerId", sellerId);
			return sqlSession.selectList("getTransaction", param);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sqlSession.close();
		}
	}
	
	
//	public static void main(String args[]) throws IOException{
//		TransactionDocDAO tdDAO=new TransactionDocDAO();
//		
////		Transaction t=new Transaction();
////		t.setGoodsId(100);
////		t.setBuyerId("t");
////		t.setSellerId("test");
//		List<Transaction> listOfTransactions=tdDAO.getMySoldTransactions("t");
//		for(Transaction t:listOfTransactions){
//			System.out.println(t.getGoodsId());
//		}
//		
//	}//end of main
	
	
}
