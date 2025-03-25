package exercicios;

import javax.swing.JOptionPane;

public class ExMatriz {

	public static void main(String[] args) {
		int rows = Integer.parseInt(JOptionPane.showInputDialog("Quantas linhas deseja em sua Matriz?")); 
		int columns = Integer.parseInt(JOptionPane.showInputDialog("Quantas colunas deseja em sua Matriz?"));
		
		int[][] mtrz = new int[rows][columns];
		
		for (int i = 0 ; i < mtrz.length ; i++) {
			for (int j = 0; j < mtrz[i].length; j++) {
				int num = Integer.parseInt(JOptionPane.showInputDialog("Qual numero deseja inserir?"));
				mtrz[i][j] = num;
			}
		}
		
		
        
        StringBuilder sb = new StringBuilder();
        sb.append("Matriz:\n");
        for (int i = 0; i < mtrz.length; i++) {
            for (int j = 0; j < mtrz[i].length; j++) {
                sb.append(mtrz[i][j]).append(" ");
            }
            sb.append("\n");
        }
        
        JOptionPane.showMessageDialog(null, sb.toString());
        
        int neighborNum = Integer.parseInt(JOptionPane.showInputDialog("Qual numero da matriz deseja saber os vizinhos? ↑↓⬅➡️" + sb.toString()));
        
        for (int i = 0; i < mtrz.length; i++) {
            for (int j = 0; j < mtrz[i].length; j++) {
            	
            	if(mtrz[i][j] == neighborNum) {		
            		
            		StringBuilder ssb = new StringBuilder();
            	
            		if (i > 0 && mtrz[i - 1][j] != 0) {
                        ssb.append("Cima ↑: ").append(mtrz[i - 1][j]).append(" ");
                    }
                    
                    if (i < mtrz.length - 1 && mtrz[i + 1][j] != 0) {
                        ssb.append("Baixo ↓: ").append(mtrz[i + 1][j]).append(" ");
                    }
                    
                    if (j < mtrz[i].length - 1 && mtrz[i][j + 1] != 0) {
                        ssb.append("Direita ➡️: ").append(mtrz[i][j + 1]).append(" ");
                    }
                    
                    if (j > 0 && mtrz[i][j - 1] != 0) {
                        ssb.append("Esquerda ⬅: ").append(mtrz[i][j - 1]).append(" ");
                    }
            		
            		JOptionPane.showMessageDialog(null, ssb.toString(), "Position: " + i + ", " + j, JOptionPane.INFORMATION_MESSAGE);
            		
            		

            		
            		
            		
            	}
           
            }
        }
        
        
        
        
        
        
        


		
		
	}
	
}
