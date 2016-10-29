package by.epamtr.veloshop.bean.entity;

public class ReportLine {// это bean
	private String productCategory;
	private int productAmount;
	private int minPrice;
	private int maxPrice;
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public int getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}
	public int getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}
	public int getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}
	@Override
	public String toString() {
		return "ReportLine [productCategory=" + productCategory + ", productAmount=" + productAmount + ", minPrice="
				+ minPrice + ", maxPrice=" + maxPrice + "]";
	}
	
}
