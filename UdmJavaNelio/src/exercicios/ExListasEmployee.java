package exercicios;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ExListasEmployee {

	private Integer uuid;
	private String name;
	private Double salary;
	
	public ExListasEmployee(Integer uuid, String name, Double salary) {
		this.uuid = uuid;
		this.name = name;
		this.salary = salary;
	}
	
	public Double increaseSalary(double percentage) {
		return salary += salary * (percentage / 100);
	}
	
	public String toString() {
		return this.uuid + ", " + this.name + ", " + this.salary;
	}

	public static void main(String[] args) {
		
		int manyEmployees = Integer.parseInt(JOptionPane.showInputDialog("How many Employees will be registered?"));
		
		List<ExListasEmployee> employeeList = new ArrayList<>();
		
		for (int i = 1; i <= manyEmployees; i++) {
			int uuid = Integer.parseInt(JOptionPane.showInputDialog(null, "ID", "Employee #"+i, JOptionPane.QUESTION_MESSAGE));
			String name = JOptionPane.showInputDialog(null, "Name", "Employee #"+i, JOptionPane.QUESTION_MESSAGE);
			double salary = Double.parseDouble(JOptionPane.showInputDialog(null, "Salary", "Employee #"+i, JOptionPane.QUESTION_MESSAGE));
			
			employeeList.add(new ExListasEmployee(uuid, name, salary));
		}
		
		int idIncrease = Integer.parseInt(JOptionPane.showInputDialog("Enter the employee id that will have salary increase:"));
		double percentageIncrease = Double.parseDouble(JOptionPane.showInputDialog("Enter the percentage:"));
		
		for(ExListasEmployee employee : employeeList) {		
			if (employee.uuid == idIncrease) {
				employee.increaseSalary(percentageIncrease);
			}
		}
		
		for(ExListasEmployee employee : employeeList) {		
			JOptionPane.showMessageDialog(null, employee);
		}		

	}
}
