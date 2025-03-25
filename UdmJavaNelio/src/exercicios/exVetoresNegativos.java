package exercicios;


import javax.swing.JOptionPane;

public class exVetoresNegativos {

	public static void main(String[] args) {
		
		
		int qntdNum = Integer.parseInt(JOptionPane.showInputDialog("Quantos Numeros Voce Quer Digitar? (MAXIMO DE 10)"));
		if (qntdNum > 0 && qntdNum > 10) {
			JOptionPane.showMessageDialog(null, "Quantidade invalida, digite no entre 1 e 10 numeros");
			qntdNum = Integer.parseInt(JOptionPane.showInputDialog("Quantos Numeros Voce Quer Digitar? (MAXIMO DE 10)"));
		}
		
		int[] nums = new int[qntdNum];
		
		for (int i = 0; i < qntdNum; i++) {
			nums[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite um Numero"));
		}
		
		JOptionPane.showMessageDialog(null, "Numeros Negativos:");
		
		for (int i = 0; i < qntdNum; i++) {
			if (nums[i] < 0) {
				JOptionPane.showMessageDialog(null, nums[i]);
			}
		}
		
		
	}
}
