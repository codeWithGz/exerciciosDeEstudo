package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import entities.*;
import services.*;
import javax.swing.JOptionPane;

public class Index {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		try {
			Integer number = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero", "Entre os dados do contrato", JOptionPane.QUESTION_MESSAGE));
			String date = (JOptionPane.showInputDialog(null, "Data (dd/MM/yyyy)", "Entre os dados do contrato", JOptionPane.QUESTION_MESSAGE));
			Date cDate = sdf.parse(date);
			Double cValue = Double.parseDouble(JOptionPane.showInputDialog(null, "Valor do contrato", "Entre os dados do contrato", JOptionPane.QUESTION_MESSAGE));
			Integer interestsQuantity = Integer.parseInt(JOptionPane.showInputDialog(null, "Entre com o numero de parcelas", "Entre os dados do contrato", JOptionPane.QUESTION_MESSAGE));
			
			Contract c1 = new Contract(number, cDate, cValue);
			
			ContractService cs = new ContractService(new PaypalService());
			
			cs.processContract(c1, interestsQuantity);
			
			StringBuilder sb = new StringBuilder();
			for (Installment i : c1.getInstallment()) {
				sb.append(i.getDueDate().format(fmt)).append(" - " + i.getAmount()).append("\n");
				
			}
			
			JOptionPane.showMessageDialog(null, sb);
			
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
	}

}
