package by.epamtr.veloshop.service;

import by.epamtr.veloshop.bean.entity.Product;
import by.epamtr.veloshop.service.exception.ServiceException;

public interface EditProductService {
	void addProduct(String name, int price, String categoryName) throws ServiceException;
	void deleteProductById(int id) throws ServiceException;
	void updateProductById(Product product) throws ServiceException;
}
