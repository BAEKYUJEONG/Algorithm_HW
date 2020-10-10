package com.ssafy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
   Connection conn;
   PreparedStatement pstmt;
   ResultSet rs;
   
   public boolean insert(Product product) {
	  
	  conn = DBUtil.getConnection();
	  String sql="insert into product (no,name,price,description) "
	  		+ "values (?,?,?,?)"; 
	  
	  try {
		pstmt = conn.prepareStatement(sql);
		  pstmt.setString(1, product.getNo());
		  pstmt.setString(2, product.getName());
		  pstmt.setInt(3, product.getPrice());
		  pstmt.setString(4, product.getDescription());
		  
		  int resultRowCnt = pstmt.executeUpdate();
		  if(resultRowCnt==1)return true;
	  } catch (SQLException e) {
		  return false;
	  } finally {
		DBUtil.close(pstmt);
		DBUtil.close(conn);
	  }
	  
	  return false;
   }//insert
   
   public boolean update(Product product) {
	   
	   conn = DBUtil.getConnection();
	   String sql="update product set name=?,price=?,description=? where no=?"; 
	   
	   try {
		   pstmt = conn.prepareStatement(sql);
		   pstmt.setString(1, product.getName());
		   pstmt.setInt(2, product.getPrice());
		   pstmt.setString(3, product.getDescription());
		   pstmt.setString(4, product.getNo());
		   
		   if(pstmt.executeUpdate()==1)return true;
	   } catch (SQLException e) {
		   return false;
	   } finally {
		   DBUtil.close(pstmt);
		   DBUtil.close(conn);
	   }
	   
	   return false;
   }//update
   
   public boolean delete(String no) {	   
	   conn = DBUtil.getConnection();
	   String sql="delete from product where no=?"; 
	   
	   try {
		   pstmt = conn.prepareStatement(sql);
		   pstmt.setString(1, no);
		   if(pstmt.executeUpdate()==1)return true;
	   } catch (SQLException e) {
		   return false;
	   } finally {
		   DBUtil.close(pstmt);
		   DBUtil.close(conn);
	   }	   
	   return false;
   }//update
   
   public Product select(String no) {
	   Product product=null;
	   conn = DBUtil.getConnection();
	   String sql="select no,name,price,description from product where no=?";
	   
	   try {
		   pstmt = conn.prepareStatement(sql);
		   pstmt.setString(1, no);
		   rs = pstmt.executeQuery();
		   if(rs.next()) {
			   product = new Product(rs.getString("no"),
					                rs.getString("name"),
					                rs.getInt("price"),
					                rs.getString("description"));
		   }
	   } catch (SQLException e) {
		   e.printStackTrace();
	   } finally {
		   DBUtil.close(rs);
		   DBUtil.close(pstmt);
		   DBUtil.close(conn);
	   }
	   
	   return product;
   }//selectAll
   
   public List<Product> selectAll() {
	   List<Product> list = new ArrayList<>();
	   conn = DBUtil.getConnection();
	   String sql="select no,name,price,description from product";
	   
	   try {
		   pstmt = conn.prepareStatement(sql);
		   rs = pstmt.executeQuery();
		   while(rs.next()) {
			   list.add(new Product(rs.getString("no"),
					   rs.getString("name"),
					   rs.getInt("price"),
					   rs.getString("description")));
		   }
	   } catch (SQLException e) {
		   e.printStackTrace();
	   } finally {
		   DBUtil.close(rs);
		   DBUtil.close(pstmt);
		   DBUtil.close(conn);
	   }
	   
	   return list;
   }//selectAll
}
