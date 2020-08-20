import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO {
	
	public Connection getConnection() {//연결객체 생성, 얻어오기
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ssafy_db?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8","root","1111");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void close(Connection connection) {//매개변수 전달된 연결 객체에 대한 자원반환
		try {
			if(connection!=null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close(PreparedStatement statement) {//매개변수에 전달된 statement 객체에 대한 자원반환
		try {
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close(ResultSet resultSet) {//매개변수에 전달된 결과집합객체에 대한 자원반환
		try {
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertProduct(Product product) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			String sql = "insert into product(num, name, price, stock) values (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, product.getNum());
			pstmt.setString(2, product.getName());
			pstmt.setInt(3, product.getPrice());
			pstmt.setInt(4, product.getStock());
			
			pstmt.executeUpdate(); //DB에게 sql실행요청 ※주의: sql문은 위에서 전달했으므로 executeUpdate() 매개변수에 sql문을 넣으면 안됨!!
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
	}
	
	public void deleteProduct(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			String sql = "delete from product where num=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
	}
	
	public void updateProduct(Product product) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			String sql = "update product set price=? where num=?"; //핵심코드!!
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, product.getPrice());
			pstmt.setInt(2, product.getNum());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
	}
	
	public Product findProduct(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Product product = null;
		
		try {
			conn = getConnection();
			String sql = "select num, name, price, stock from product where num=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, product.getNum());
			
			rs = pstmt.executeQuery(); //DB에게 SQL 실행요청! ※주의 : sql문은 위에서 전달했으므로 executeQuery() 매개변수에 sql문을 넣으면 안됨!!
			//rs는 ResultSet!! 즉, 조회된 결과 집합인데
			//▶이후, 따당~~~!!◀이 꼭 필요함!!  '따'--> rs.next()  '당'--> rs.get자료형(컬럼명);
			//rs.next() ==> select를 통해 얻어온 행열데이터중  첫번째 행부터 얻는 역할을 하는데
			//              더 이상 얻을 행이 없다면 return false를 반환!!
			
			if(rs.next()) {
				product = new Product(rs.getInt("num"),
										rs.getString("name"),
										rs.getInt("price"),
										rs.getInt("stock"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		
		return product;
	}
	
	public List<Product> findNameProducts() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Product> list = new ArrayList<>();
		
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public List<Product> findNameProducts() {
		
	}
	
}












