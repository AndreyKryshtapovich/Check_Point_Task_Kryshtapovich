package by.epamtr.veloshop.service.impl;

import by.epamtr.veloshop.bean.entity.Product;
import by.epamtr.veloshop.dao.DaoFactory;
import by.epamtr.veloshop.dao.VeloDao;
import by.epamtr.veloshop.dao.exception.DaoException;
import by.epamtr.veloshop.service.EditProductService;
import by.epamtr.veloshop.service.exception.ServiceException;

public class EditProduct implements EditProductService {
	private final static String invalidParameters = "Invalid parameters";
	private final static String failedAdding = "Failed adding a product";
	private final static String failedDeletting = "Failed deletting a product";
	private final static String failedUpdating = "Failed updating a product";

	@Override
	public void addProduct(String name, int price, String categoryName) throws ServiceException {
		if(name == null || "".equals(name) || price <= 0 || categoryName == null || "".equals(categoryName)){
			throw new ServiceException(invalidParameters);
		}
		
		DaoFactory factory = DaoFactory.getInstance();
		VeloDao veloDao = factory.getVeloDao();
		
		try {
			veloDao.addProduct(name, price, categoryName);
		} catch (DaoException e) {
			throw new ServiceException(failedAdding,e);
		}
	}

	@Override
	public void deleteProductById(int id) throws ServiceException {
		if(id <= 0){
			throw new ServiceException(invalidParameters);
		}
		
		DaoFactory factory = DaoFactory.getInstance();
		VeloDao veloDao = factory.getVeloDao();
		
		try {
			veloDao.deleteProductById(id);
		} catch (DaoException e) {
			throw new ServiceException(failedDeletting,e);
		}
		
	}

	@Override
	public void updateProductById(Product product) throws ServiceException {
		if(product.getId() <= 0 || product.getName() == null || "".equals(product.getName())||
		   product.getCategory() == null || "".equals(product.getCategory()) || product.getPrice() <= 0){
			
			throw new ServiceException(invalidParameters);
			
		}
		
		DaoFactory factory = DaoFactory.getInstance();
		VeloDao veloDao = factory.getVeloDao();
		
		try {
			veloDao.updateProductById(product);
		} catch (DaoException e) {
			throw new ServiceException(failedUpdating,e);
		}
	}

}
