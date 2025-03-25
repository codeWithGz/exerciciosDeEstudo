package src;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import entities.Client;
import entities.OrderItem;
import entities.Product;
import entitiesEnum.OrderStatus;
import entities.Order;

public class Index {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		JOptionPane.showMessageDialog(null, "Enter Client Data");
		String cName = JOptionPane.showInputDialog("Name");
		String cEmail = JOptionPane.showInputDialog("Email");
		String cBdayStr = JOptionPane.showInputDialog(null, "Birth date (DD/MM/YYYY)");
		Date cBday = sdf.parse(cBdayStr);
		Client c1 = new Client(cName, cEmail, cBday);
		
		JOptionPane.showMessageDialog(null, "Enter Order Data");
		String status = JOptionPane.showInputDialog("Status");
		Integer manyItens = Integer.parseInt(JOptionPane.showInputDialog("How many items to this order?"));
		List<OrderItem> ois = new ArrayList<>();
		for (int i = 1 ; i <= manyItens ; i++) {
			
			
			String pName = JOptionPane.showInputDialog(null, "Product name:", "Enter #" + i + " item data", JOptionPane.QUESTION_MESSAGE);
			Double pPrice = Double.parseDouble(JOptionPane.showInputDialog(null, "Product price:", "Enter #" + i + " item data", JOptionPane.QUESTION_MESSAGE));
			Integer pQuantity = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantity:", "Enter #" + i + " item data", JOptionPane.QUESTION_MESSAGE));
			Product p = new Product(pName, pPrice);
			OrderItem orderI = new OrderItem(pQuantity, pPrice, p);
			ois.add(orderI);
		}
		
		
		Order o1 = new Order(new Date(), OrderStatus.valueOf(status), c1);
		for(OrderItem oi : ois) {
			o1.addItem(oi);
		}
		
		JOptionPane.showMessageDialog(null, o1, "Order Sumary", JOptionPane.PLAIN_MESSAGE);
		
		
	}

}
