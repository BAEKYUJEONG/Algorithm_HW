package com.ssafy.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dto.Product;

public interface ProductService {
//사용자 입장에서 메소드명을 정의하는 것이 좋다
//참고) DAO클래스 --> DB입장에서 메소드명을 정의하는 것이 좋다.
	
	public void regist(Product product)throws SQLException;
	public void modify(Product product)throws SQLException;
	public void remove(String id)throws SQLException;
	
	public Product find(String id)throws SQLException;
	public List<Product> findAll()throws SQLException;
}
