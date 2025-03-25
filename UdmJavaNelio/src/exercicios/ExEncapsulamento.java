package exercicios;



import javax.swing.JOptionPane;

public class ExEncapsulamento {

	
	private int number;
	private String holder;
	private double balance;
	
	public ExEncapsulamento(int number, String holder) {
		this.number = number;
		this.holder = holder;
	}
	protected int getNumber() {
		return number;
	}
	
	protected String getHolder() {
		return holder;
	}

	protected void setHolder(String holder) {
		this.holder = holder;
	}


	protected double getBalance() {
		return balance;
	}
	
	
	public double deposit(double value) {
		return this.balance += value;
	}
	
	public double withdraw(double value) {
		return this.balance -= (value + 5);
		
	}
	
	public String toString() {
		return "Account Data: \n" + "Account Number: " + this.getNumber() + " Holder: " + this.getHolder() + " Balance: $ " + this.getBalance();
	}
	
	public String toStringUpdated() {
		return "Updated account Data: \n" + "Account Number: " + this.getNumber() + " Holder: " + this.getHolder() + " Balance: $ " + this.getBalance();
	}
	
	
	public static void main(String[] args) {
		
		int accNum = Integer.parseInt(JOptionPane.showInputDialog("Enter Account number:")) ;
		String accName = JOptionPane.showInputDialog("Enter account holder:");
		ExEncapsulamento c1 = new ExEncapsulamento(accNum, accName);
		
		int accInitDeposit = JOptionPane.showConfirmDialog(null, "Is there an initial deposit?");
		
		if (accInitDeposit == JOptionPane.YES_OPTION) {
			double accFirstDeposit = Double.parseDouble(JOptionPane.showInputDialog("Enter initial deposit value"));
			c1.deposit(accFirstDeposit);
		} 
		
		JOptionPane.showMessageDialog(null, c1.toString());
		
		double depositValue = Double.parseDouble(JOptionPane.showInputDialog("Enter deposit value:"));
		c1.deposit(depositValue);
		JOptionPane.showMessageDialog(null, c1.toStringUpdated());
		
		depositValue = Double.parseDouble(JOptionPane.showInputDialog("Enter withdraw value:"));
		c1.withdraw(depositValue);
		JOptionPane.showMessageDialog(null, c1.toStringUpdated());
		
		
		
		
		
		
	}
	
	
	
	
	
}
