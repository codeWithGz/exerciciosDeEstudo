package exercicios;

import javax.swing.JOptionPane;

public class exVetoresSomaVetor {
	
	public static void main(String[] args) {
		int qntdNum = Integer.parseInt(JOptionPane.showInputDialog("Quantos Numeros Voce Quer Digitar? (MAXIMO DE 10)"));
		if (qntdNum > 0 && qntdNum > 10) {
			JOptionPane.showMessageDialog(null, "Quantidade invalida, digite no entre 1 e 10 numeros");
			qntdNum = Integer.parseInt(JOptionPane.showInputDialog("Quantos Numeros Voce Quer Digitar? (MAXIMO DE 10)"));
		}
		
		double[] nums = new double[qntdNum];
		
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Double.parseDouble(JOptionPane.showInputDialog("Digite um Numero"));
		}
		
		JOptionPane.showMessageDialog(null, "Valores:");
		for(double num : nums) {
			JOptionPane.showMessageDialog(null, num);
		}
		
		double soma = 0;
		
		for (int i = 0; i < nums.length; i++) {
			soma += nums[i];
		}
		
		double media = soma / nums.length;
		
		JOptionPane.showMessageDialog(null, "Soma = " + soma);
		JOptionPane.showMessageDialog(null, "Media = " + media);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
