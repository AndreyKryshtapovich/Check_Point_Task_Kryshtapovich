package by.epamtr.veloshop.command.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epamtr.veloshop.bean.Request;
import by.epamtr.veloshop.bean.Response;
import by.epamtr.veloshop.bean.SearchProductRequest;
import by.epamtr.veloshop.command.Command;
import by.epamtr.veloshop.service.SearchProductService;
import by.epamtr.veloshop.service.ServiceFactory;
import by.epamtr.veloshop.service.exception.ServiceException;
import by.epamtr.veloshop.bean.entity.Product;
public class ShowProductsByCategory implements Command {

	private final static Logger rootLogger =  LogManager.getRootLogger();
	
	@Override
	public Response execute(Request request) {
		
		List<Product> productList = null;
		SearchProductRequest searchProductRequest = null;
		if(request instanceof SearchProductRequest){
			searchProductRequest = (SearchProductRequest)request;
		}
		
		String categoryName = searchProductRequest.getCategoryName();
		
		Response response = new Response();
		
		 ServiceFactory factory = ServiceFactory.getInstance();
		 SearchProductService searchService = factory.getSearchProductService();
		
		try {
			productList = searchService.showProductByCategory(categoryName);
			response.setErrorStatus(false);
			response.setProducts(productList);
		} catch (ServiceException e) {
			response.setErrorStatus(false);
			response.setErrorMessage(e.getMessage());
			rootLogger.error(e.getMessage());
		}
		
		return response;
	}

}
