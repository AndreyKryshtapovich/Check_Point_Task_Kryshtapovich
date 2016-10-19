package by.epamtr.veloshop.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epamtr.veloshop.bean.Request;
import by.epamtr.veloshop.bean.Response;
import by.epamtr.veloshop.bean.UpdateProductRequest;
import by.epamtr.veloshop.bean.entity.Product;
import by.epamtr.veloshop.command.Command;
import by.epamtr.veloshop.service.EditProductService;
import by.epamtr.veloshop.service.ServiceFactory;
import by.epamtr.veloshop.service.exception.ServiceException;

public class UpdateProductById implements Command {

	private final static Logger rootLogger =  LogManager.getRootLogger();
	private final static String idRow = "запись id = ";
	private final static String updated = " обновлена";
	@Override
	public Response execute(Request request) {
	
		UpdateProductRequest updateProductRequest = null;
		if(request instanceof UpdateProductRequest){
			updateProductRequest = (UpdateProductRequest)request;
		}
		
		int id = updateProductRequest.getId();
		String name = updateProductRequest.getName();
		String categoryName = updateProductRequest.getCategory();
		int price = updateProductRequest.getPrice();
		
		Product product = new Product();
		product.setId(id);
		product.setCategory(categoryName);
		product.setName(name);
		product.setPrice(price);
		
	    ServiceFactory factory = ServiceFactory.getInstance();
	    EditProductService editService = factory.getEditProductService();
	    
	    Response response = new Response();
	    
		try {
			editService.updateProductById(product);
			response.setErrorStatus(false);
			response.setSimpleMessage(idRow + product.getId() + updated);
		} catch (ServiceException e) {
			response.setErrorStatus(false);
			response.setErrorMessage(e.getMessage());
			rootLogger.error(e.getMessage());
		}
		
		return response;
	}

}
