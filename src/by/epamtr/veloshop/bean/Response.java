package by.epamtr.veloshop.bean;



import java.util.List;

import by.epamtr.veloshop.bean.entity.Product;
import by.epamtr.veloshop.bean.entity.ReportLine;

public class Response {
	private boolean errorStatus;
	private String errorMessage;
	private String simpleMessage;
	private List<Product> products;
	private List<ReportLine> report;

	public List<ReportLine> getReport() {
		return report;
	}

	public void setReport(List<ReportLine> report) {
		this.report = report;
	}

	public boolean isErrorStatus() {
		return errorStatus;
	}

	public void setErrorStatus(boolean errorStatus) {
		this.errorStatus = errorStatus;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getSimpleMessage() {
		return simpleMessage;
	}

	public void setSimpleMessage(String simpleMessage) {
		this.simpleMessage = simpleMessage;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
