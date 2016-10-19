package by.epamtr.veloshop.start;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epamtr.veloshop.bean.AddProductRequest;
import by.epamtr.veloshop.bean.DeleteProductRequest;
import by.epamtr.veloshop.bean.Request;
import by.epamtr.veloshop.bean.Response;
import by.epamtr.veloshop.bean.SearchProductRequest;
import by.epamtr.veloshop.bean.UpdateProductRequest;
import by.epamtr.veloshop.bean.entity.Product;
import by.epamtr.veloshop.bean.entity.ReportLine;
import by.epamtr.veloshop.command.CommandName;
import by.epamtr.veloshop.controller.Controller;

public class Main {
	
	private final static Logger rootLogger =  LogManager.getRootLogger();

	public static void main(String[] args) {
		Controller controller = new Controller();
		
		AddProductRequest addRequest = new AddProductRequest();
		addRequest.setCommandName(CommandName.ADD_PRODUCT);
		addRequest.setName("SuperGloves");
		addRequest.setPrice(560);
		addRequest.setCategory("equipment");
		Response response = controller.doAction(addRequest);
		if(! response.isErrorStatus()){ 
			rootLogger.info(response.getSimpleMessage());
		}else{
			rootLogger.info(response.getErrorMessage());
		}
		
		DeleteProductRequest deleteRequest = new DeleteProductRequest();
		
		deleteRequest.setCommandName(CommandName.DELETE_PRODUCT_BY_ID);
		deleteRequest.setIdToDelete(8);
		Response response1 = controller.doAction(deleteRequest);
		if(! response1.isErrorStatus()){
			rootLogger.info(response1.getSimpleMessage());
		}else{
			rootLogger.info(response1.getErrorMessage());
		}
		
		SearchProductRequest searchRequest = new SearchProductRequest();
		searchRequest.setCommandName(CommandName.SHOW_PRODUCTS_BY_CATEGORY);
		searchRequest.setCategoryName("cycles");
		Response response2 = controller.doAction(searchRequest);
		if(! response2.isErrorStatus()){
			if(response2.getProducts() != null){
				for(Product p : response2.getProducts()){
					rootLogger.info(p.toString());
				}
			}
			}else{
				rootLogger.info(response2.getErrorMessage());
			}
		
		UpdateProductRequest updateRequest = new UpdateProductRequest();
		updateRequest.setCommandName(CommandName.UPDATE_PRODUCT_BY_ID);
		updateRequest.setCategory("equipment");
		updateRequest.setId(10);
		updateRequest.setName("boots");
		updateRequest.setPrice(777);
		Response response3 = controller.doAction(updateRequest);
		if(! response3.isErrorStatus()){
			rootLogger.info(response3.getSimpleMessage());
			
			}else{
				rootLogger.info(response3.getErrorMessage());
	
			}
		
		Request request = new Request();
		request.setCommandName(CommandName.SHOW_REPORT);
		Response response4 = controller.doAction(request);
		if(! response4.isErrorStatus()){
			if(response4.getReport() != null){
				for(ReportLine r : response4.getReport()){
					rootLogger.info(r.toString());
				}
			}
			}else{
				rootLogger.info(response4.getErrorMessage());
			}
		
	}


}
