package by.epamtr.veloshop.service;

import java.util.List;
import by.epamtr.veloshop.bean.entity.Product;
import by.epamtr.veloshop.bean.entity.ReportLine;
import by.epamtr.veloshop.service.exception.ServiceException;

public interface SearchProductService {
	List<Product> showProductByCategory(String categoryName) throws ServiceException;
	List<ReportLine> showReport() throws ServiceException;
	
}
