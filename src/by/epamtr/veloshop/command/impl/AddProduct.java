package by.epamtr.veloshop.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epamtr.veloshop.bean.AddProductRequest;
import by.epamtr.veloshop.bean.Request;
import by.epamtr.veloshop.bean.Response;
import by.epamtr.veloshop.command.Command;
import by.epamtr.veloshop.service.EditProductService;
import by.epamtr.veloshop.service.ServiceFactory;
import by.epamtr.veloshop.service.exception.ServiceException;


public class AddProduct implements Command {
	private final static Logger rootLogger =  LogManager.getRootLogger();
	private final static String addRow = "запись добавлена";

	@Override
	public Response execute(Request request) {
		AddProductRequest addProductRequest = null;
		if(request instanceof AddProductRequest){
			addProductRequest = (AddProductRequest)request;
		}
		
		String name = addProductRequest.getName();
		int price = addProductRequest.getPrice();
		String categoryName = addProductRequest.getCategory();
		
	    ServiceFactory factory = ServiceFactory.getInstance();
	    EditProductService editService = factory.getEditProductService();
	    
	    Response response = new Response();
	    try {
			editService.addProduct(name, price, categoryName);
			response.setErrorStatus(false);
			response.setSimpleMessage(addRow);
		} catch (ServiceException e) {
			response.setErrorStatus(false);
			response.setErrorMessage(e.getMessage());
			rootLogger.error(e.getMessage());
		}
	    
		return response;
	}

}
