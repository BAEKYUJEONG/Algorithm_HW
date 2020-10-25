package com.ssafy.model.repository;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dto.Product;

public interface ProductDAO {
    public void insert(Product product)throws SQLException;
    public void update(Product product)throws SQLException;
    public void delete(String id)throws SQLException;
   
    public Product select(String id)throws SQLException;
    public List<Product> selectAll()throws SQLException;
}
