package by.epamtr.veloshop.command.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epamtr.veloshop.bean.Request;
import by.epamtr.veloshop.bean.Response;
import by.epamtr.veloshop.bean.entity.ReportLine;
import by.epamtr.veloshop.command.Command;
import by.epamtr.veloshop.service.SearchProductService;
import by.epamtr.veloshop.service.ServiceFactory;
import by.epamtr.veloshop.service.exception.ServiceException;

public class ShowReport implements Command {
	private final static Logger rootLogger =  LogManager.getRootLogger();

	@Override
	public Response execute(Request request) {
		List<ReportLine> reportList = null;
		Response response = new Response();
		
		 ServiceFactory factory = ServiceFactory.getInstance();
		 SearchProductService searchService = factory.getSearchProductService();
		 
		 try {
			 reportList = searchService.showReport();
				response.setErrorStatus(false);
				response.setReport(reportList);
			} catch (ServiceException e) {
				response.setErrorStatus(false);
				response.setErrorMessage(e.getMessage());
				rootLogger.error(e.getMessage());
			}
		return response;
	}

}
