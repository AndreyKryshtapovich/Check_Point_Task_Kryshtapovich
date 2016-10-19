package by.epamtr.veloshop.service.impl;

import java.util.List;

import by.epamtr.veloshop.bean.entity.Product;
import by.epamtr.veloshop.bean.entity.ReportLine;
import by.epamtr.veloshop.dao.DaoFactory;
import by.epamtr.veloshop.dao.VeloDao;
import by.epamtr.veloshop.dao.exception.DaoException;
import by.epamtr.veloshop.service.SearchProductService;
import by.epamtr.veloshop.service.exception.ServiceException;

public class SearchProduct implements SearchProductService {
	private final static String invalidParameters = "Invalid parameters";
	private final static String failedObtainingList = "Failed obtaining product list";
	private final static String failedGeneratingaReport = "Failed generating a report";

	@Override
	public List<Product> showProductByCategory(String categoryName) throws ServiceException {
		if(categoryName == null || "".equals(categoryName)){
			throw new ServiceException(invalidParameters);
		}
		
		DaoFactory factory = DaoFactory.getInstance();
		VeloDao veloDao = factory.getVeloDao();
		List<Product> productList = null;
		try {
			productList =  veloDao.showProductByCategory(categoryName);
		} catch (DaoException e) {
			throw new ServiceException(failedObtainingList,e);
		}
		
		return productList;
	}

	@Override
	public List<ReportLine> showReport() throws ServiceException {
		
		DaoFactory factory = DaoFactory.getInstance();
		VeloDao veloDao = factory.getVeloDao();
		List<ReportLine> reportList = null;
		try {
			reportList =  veloDao.showReport();
		} catch (DaoException e) {
			throw new ServiceException(failedGeneratingaReport,e);
		}
		return reportList;
	}



}
