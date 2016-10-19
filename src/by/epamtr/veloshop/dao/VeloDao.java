package by.epamtr.veloshop.dao;

import java.util.List;

import by.epamtr.veloshop.bean.entity.Product;
import by.epamtr.veloshop.bean.entity.ReportLine;
import by.epamtr.veloshop.dao.exception.DaoException;

public interface VeloDao {
	
	void addProduct(String name, int price, String categoryName) throws DaoException;
	void deleteProductById(int id) throws DaoException;
	List<Product> showProductByCategory(String categoryName) throws DaoException;
	List<ReportLine> showReport() throws DaoException;
	void updateProductById(Product product) throws DaoException;
	
}
