package DAO;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pojo.Goods;

public class GoodsInfoDocDAO {
	public SqlSession getSession() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory.openSession();
	}
	
	public List<Goods> getAllSellingGoods() throws IOException{
		SqlSession sqlSession=getSession();
		Map<String,String> param = new HashMap<>();
		param.put("status", "SELLING");
		List<Goods> resGoodsList=sqlSession.selectList("getGoods", param);
		sqlSession.close();
		return resGoodsList;
	}
	public List<Goods> getPersonalGoods(String sellerId) throws IOException{
		SqlSession sqlSession=getSession();
		Map<String,String> param = new HashMap<>();
		param.put("sellerId", sellerId);
		List<Goods> resGoodsList = sqlSession.selectList("getGoods", param);
		sqlSession.close();
		return resGoodsList;
	}
	public Goods getGoods(int goodsId) throws IOException{
		SqlSession sqlSession=getSession();
		Map<String,Integer> param = new HashMap<>();
		param.put("goodsId", goodsId);
		try{
			Goods resGoods=sqlSession.selectOne("getGoods",param);
			return resGoods;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally {
			sqlSession.close();
		}
	}
	
	public boolean addGoods(Goods goods) throws IOException {
		SqlSession sqlSession =getSession();
		try{
			sqlSession.insert("addGoods",goods);
			sqlSession.commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally {
			sqlSession.close();
		}
		
	}
	
	public boolean setSELLED(int goodsId) throws IOException{
		SqlSession sqlSession=getSession();
		try{
			sqlSession.update("setSELLED",goodsId);
			sqlSession.commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally {
			sqlSession.close();
		}
	}
	
	public boolean updateGoods(Goods newGoods) throws IOException{
		SqlSession sqlSession=getSession();
		try{
			sqlSession.update("updateGoods", newGoods);
			sqlSession.commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally {
			sqlSession.close();
		}
	}
	public boolean deleteGoods(HttpServletRequest request,int goodsId) throws IOException{
		SqlSession sqlSession=getSession();
		try{
			//先存下pictureId，记录成功删除可以用于后续删图片，记录删除不成功则pictureId用不上
			String pictureId=getGoods(goodsId).getPictureId();
			//删除记录
			sqlSession.delete("deleteGoods",goodsId);
			//删除图片
			File goodsImageFile = new File(request.getServletContext().getRealPath("/GoodsImg"), pictureId);
			if(goodsImageFile.exists()){
				goodsImageFile.delete();
			}//没有用的注释
//			}else{
//				return false;	//图片不存在
//			}
			sqlSession.commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally {
			sqlSession.close();
		}
	}
	

//	public static void main(String args[]) throws IOException{
//		GoodsInfoDocDAO gidDAO=new GoodsInfoDocDAO();
//		
////		goods.setGoodsId(1);
////		goods.setName("testgoods");
////		goods.setDescription("tt");
////		goods.setPictureId(1);
////		goods.setSellerId("test");
//		
//		
//	}

}

