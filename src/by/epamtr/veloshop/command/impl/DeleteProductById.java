package by.epamtr.veloshop.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epamtr.veloshop.bean.DeleteProductRequest;
import by.epamtr.veloshop.bean.Request;
import by.epamtr.veloshop.bean.Response;
import by.epamtr.veloshop.command.Command;
import by.epamtr.veloshop.service.EditProductService;
import by.epamtr.veloshop.service.ServiceFactory;
import by.epamtr.veloshop.service.exception.ServiceException;

public class DeleteProductById  implements Command{
	private final static Logger rootLogger =  LogManager.getRootLogger();
	private final static String deleteRow = "запись удалена";

	@Override
	public Response execute(Request request) {
		
		DeleteProductRequest deleteProductRequest = null;
		if(request instanceof DeleteProductRequest){
			deleteProductRequest = (DeleteProductRequest)request;
		}
		
		int idToDelete = deleteProductRequest.getIdToDelete();
		
	    ServiceFactory factory = ServiceFactory.getInstance();
	    EditProductService editService = factory.getEditProductService();
	    
		Response response = new Response();
		
		try {
			editService.deleteProductById(idToDelete);;
			response.setErrorStatus(false);
			response.setSimpleMessage(deleteRow);
		} catch (ServiceException e) {
			response.setErrorStatus(false);
			response.setErrorMessage(e.getMessage());
			rootLogger.error(e.getMessage());
		}
		
		return response;
	}

}
