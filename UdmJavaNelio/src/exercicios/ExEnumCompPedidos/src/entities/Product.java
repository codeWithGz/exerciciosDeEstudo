package entities;

public class Product {

	private String name;
	private Double price;
	
	public Product() {
	}
	
	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected Double getPrice() {
		return price;
	}

	protected void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "TESTETETETEETETE";
	}
	
	
	
}
