package src;

public interface MecanicaDoJogo {
	
	boolean tentativaDeAcerto(String tentativa);
	boolean fimDeJogo();
	int getPontuacao();
	String getPalavraEmbaralhada();
	String getPalavraNormal();
	int getTentativas();
	int getMaxTentativas();
}
