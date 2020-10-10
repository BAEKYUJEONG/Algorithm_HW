package com.ssafy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MemberDAO {
    Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;	
	
    public void insert(Member m) {}
    public void delete(String id) {}
    public void update(Member m) {}
    public Member select(String id) {return null;}
    public List<Member> selectAll() {return null;}
    
    public boolean selectLogin(String id, String pw) {
    	
 	   conn = DBUtil.getConnection();
 	   String sql="select count(*) from member where id=? and pw=?";
 	   
 	   try {
 		   pstmt = conn.prepareStatement(sql);
 		   pstmt.setString(1, id);
 		   pstmt.setString(2, pw);
 		   rs = pstmt.executeQuery();
 		   if(rs.next()) {
               int cnt = rs.getInt(1);
               if(cnt==1)return true;
 		   }
 	   } catch (SQLException e) {
 		   e.printStackTrace();
 	   } finally {
 		   DBUtil.close(rs);
 		   DBUtil.close(pstmt);
 		   DBUtil.close(conn);
 	   } 	   
 	   return false;
    }//selectLogin
}
