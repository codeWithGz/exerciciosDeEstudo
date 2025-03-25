package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entitiesEnum.OrderStatus;

public class Order {
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private Date moment;
	private OrderStatus status;
	
	private Client client;
	private List<OrderItem> itens = new ArrayList<>();
	
	public Order() {
	}
	
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	protected Date getMoment() {
		return moment;
	}

	protected void setMoment(Date moment) {
		this.moment = moment;
	}

	protected OrderStatus getStatus() {
		return status;
	}

	protected void setStatus(OrderStatus status) {
		this.status = status;
	}

	protected Client getClient() {
		return client;
	}

	protected void setClient(Client client) {
		this.client = client;
	}

	protected List<OrderItem> getItens() {
		return itens;
	}
	
	public void addItem(OrderItem item) {
		itens.add(item);
	}
	
	public void removeItem(OrderItem item) {
		itens.remove(item);
	}
	
	public Double total() {
		Double totalValue = 0.0;
		for (OrderItem o : itens) {
			totalValue += o.subTotal();
		}
		
		return totalValue;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: " + sdf.format(moment) + "\n");
		sb.append("Order status: " + status + "\n");
		sb.append(client + "\n");
		sb.append("Order Itens:\n");
		for(OrderItem oi : itens) {
			sb.append(oi + "\n");			
		}
		
		sb.append("Total Price: $" + total());
		
		return sb.toString();
	}
	
	

	
	
}
