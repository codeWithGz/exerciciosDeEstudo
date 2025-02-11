package mecanicasDeJogo;

import src.FabricaEmbaralhadores;
import src.BancoDePalavras;
import src.MecanicaDoJogo;

public class MecanicaDificil implements MecanicaDoJogo {
    private final String palavraOriginal;
    private final String palavraEmbaralhada;
    private int tentativas;
    private boolean acertou;
    public static final int MAX_TENTATIVAS = 1;
    
    public MecanicaDificil(BancoDePalavras banco) {
        this.palavraOriginal = banco.getPalavraAleatoria();
        this.palavraEmbaralhada = FabricaEmbaralhadores.getEmbaralhadorAleatorio().embaralhada(palavraOriginal);
        this.tentativas = 0;
        this.acertou = false;
    }
    
    public boolean tentativaDeAcerto(String tentativa) {
        tentativas++;
        if (tentativa.equalsIgnoreCase(palavraOriginal)) {
            acertou = true;
            return true;
        }
        return false;
    }
    
    public boolean fimDeJogo() {
        return acertou || tentativas >= MAX_TENTATIVAS;
    }
    
    public int getPontuacao() {
        return acertou ? (MAX_TENTATIVAS - tentativas + 1) * 10 : 0;
    }

	@Override
	public String getPalavraEmbaralhada() {
		return palavraEmbaralhada;
	}
	
	@Override
	public String getPalavraNormal() {
		return palavraOriginal;
	}

	@Override
	public int getTentativas() {
		return this.tentativas;
	}

	@Override
	public int getMaxTentativas() {
		
		return this.MAX_TENTATIVAS;
	}
}