package by.epamtr.veloshop.service;

import by.epamtr.veloshop.service.impl.EditProduct;
import by.epamtr.veloshop.service.impl.SearchProduct;

public class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();
	
	private EditProductService editProductService = new EditProduct();
	private SearchProductService searchProductService = new SearchProduct();
	
	private ServiceFactory(){}
	
	
	public static ServiceFactory getInstance(){
		return instance;
	}
	
	public EditProductService getEditProductService(){
		return editProductService;
	}
	
	public SearchProductService getSearchProductService(){
		return searchProductService;
	}

}
