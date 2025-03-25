package entities;

public class OrderItem {

	private Integer quantity;
	private Double price;
	
	private Product product;
	
	public OrderItem() {
	}

	public OrderItem(Integer quantity, Double price, Product product) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}

	protected Integer getQuantity() {
		return quantity;
	}
	protected void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	protected Double getPrice() {
		return price;
	}
	protected void setPrice(Double price) {
		this.price = price;
	}

	public Double subTotal() {
		return quantity * price;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.product.getName() + ", $" + price + ", Quantity: " + quantity + ", Subtotal: $" + subTotal());
		
		return sb.toString();
	}
	
	
	
}
