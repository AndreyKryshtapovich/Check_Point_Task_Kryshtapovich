package by.epamtr.veloshop.bean;

public class SearchProductRequest extends Request {
	private String categoryName;
	
	public SearchProductRequest (){}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
}
