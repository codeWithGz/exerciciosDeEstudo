package exercicios;

import javax.swing.JOptionPane;

public class ex02POO {
	
	private String name;
	private double grossSalary;
	private double tax;
	
	public double netSalary() {
		return grossSalary - tax;
	}
	
	public void increaseSalary(double percentage) {
		grossSalary += (grossSalary * (percentage / 100));
	}
	
	public String toString() {
		return "Employee: " + name + ", $ " + netSalary();
		
	}
	
	public static void main(String[] args) {

		ex02POO fnc = new ex02POO();
		
		fnc.name = JOptionPane.showInputDialog("Qual o nome do Funcionario?");
		fnc.grossSalary = Double.parseDouble(JOptionPane.showInputDialog("Qual o salario do Funcionario?"));
		fnc.tax = Double.parseDouble(JOptionPane.showInputDialog("Qual o imposto do Funcionario?"));

		JOptionPane.showMessageDialog(null, fnc);
		
		fnc.increaseSalary(Double.parseDouble(JOptionPane.showInputDialog("Qual a porcentagem de aumento no Salario?")));
		

		JOptionPane.showMessageDialog(null, fnc);
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
