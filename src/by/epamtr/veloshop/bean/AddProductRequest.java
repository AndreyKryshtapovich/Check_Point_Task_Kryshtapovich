package by.epamtr.veloshop.bean;

public class AddProductRequest extends Request {
	
	private String name;
	private int price;
	private String category;
	
	public AddProductRequest(){}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
}
