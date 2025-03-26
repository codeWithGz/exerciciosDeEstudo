package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.JOptionPane;

public class Index {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		List<TaxPayer> taxPayers = new ArrayList<>();
		
		Integer quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tax payers"));
		
		for (int i = 1 ; i <= quantity ; i++) {
			
			String[] options = {"Individual", "Company"};
			String _type = (String) 
			JOptionPane.showInputDialog(null, "Choose an Option", "Tax payer #" + i + " data", JOptionPane.QUESTION_MESSAGE, null, options, "");
			
			String name = JOptionPane.showInputDialog(null, "Name", "Tax payer #" + i + " data", JOptionPane.QUESTION_MESSAGE);
			Double anual = Double.parseDouble(JOptionPane.showInputDialog(null, "Anual income", "Tax payer #" + i + " data", JOptionPane.QUESTION_MESSAGE));
			
			switch (_type) {
			case "Individual": {
				Double health = Double.parseDouble(JOptionPane.showInputDialog(null, "Health expenditures", "Tax payer #" + i + " data", JOptionPane.QUESTION_MESSAGE));
				taxPayers.add(new Individual(name, anual, health));
				break;
			}
			default:
				Integer employeesNum = Integer.parseInt(JOptionPane.showInputDialog(null, "Number of employees", "Tax payer #" + i + " data", JOptionPane.QUESTION_MESSAGE));
				taxPayers.add(new Company(name, anual, employeesNum));
				break;
			}
			
			
			
					}
		
		StringBuilder sb = new StringBuilder();
		Double sum = 0.0;
		for (TaxPayer tp : taxPayers) {
			sb.append(tp + "\n");
		}
		
		for (TaxPayer tp : taxPayers) {
			sum += tp.valorPagoImposto ;
		}
		
		
		sb.append("TOTAL TAXES: $ " + String.format("%.2f", sum));
		JOptionPane.showMessageDialog(null, sb);
		
		
		
	}

}
