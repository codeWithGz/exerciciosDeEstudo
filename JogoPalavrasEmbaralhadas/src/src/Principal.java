package src;

import java.io.InputStream;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import mecanicasDeJogo.MecanicaFacil;
import mecanicasDeJogo.MecanicaMedia;
import mecanicasDeJogo.MecanicaDificil;

public class Principal {
    public static void main(String[] args) {
        InputStream arquivoPalavras = Principal.class.getResourceAsStream("/assets/palavras.txt");
        BancoDePalavras banco = new BancoDePalavras(arquivoPalavras);

        URL iconUrl = Principal.class.getResource("/assets/gz.jpg");
        ImageIcon icon = new ImageIcon(iconUrl);

        Object[] opcoes = { "Fácil", "Médio", "Difícil" };
        int escolha = JOptionPane.showOptionDialog(
                null, "Escolha o nível de dificuldade:", "Palavras Embaralhadas do Gz!",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, icon, opcoes, opcoes[0]);

        MecanicaDoJogo jogo;
        switch (escolha) {
            case 1: jogo = new MecanicaMedia(banco); break;
            case 2: jogo = new MecanicaDificil(banco); break;
            default: jogo = new MecanicaFacil(banco); break; // Padrão
        }

        int maxVidas = jogo.getMaxTentativas();
        String[] coracoes = new String[maxVidas + 1];

        for (int i = 0; i <= maxVidas; i++) {
            coracoes[i] = "❤️".repeat(maxVidas - i);
        }

        while (!jogo.fimDeJogo()) {
            String mensagem = "Tente adivinhar a palavra: " + jogo.getPalavraEmbaralhada() +
                              "\nVidas restantes: " + coracoes[jogo.getTentativas()];

            String tentativa = (String) JOptionPane.showInputDialog(null, mensagem,
                    "Palavras Embaralhadas do Gz!", JOptionPane.PLAIN_MESSAGE, icon, null, "");

            if (tentativa == null) {
                JOptionPane.showMessageDialog(null, "Jogo encerrado!", "Palavras Embaralhadas do Gz!",
                        JOptionPane.WARNING_MESSAGE, icon);
                System.exit(0);
            }

            if (jogo.tentativaDeAcerto(tentativa)) {
                JOptionPane.showMessageDialog(null, "Parabéns! Você acertou!",
                        "Palavras Embaralhadas do Gz!", JOptionPane.INFORMATION_MESSAGE, icon);
                break;
            } else if (!jogo.fimDeJogo()) {
                JOptionPane.showMessageDialog(null, "Errado! Tente novamente.\nVidas restantes: " + coracoes[jogo.getTentativas()],
                        "Palavras Embaralhadas do Gz!", JOptionPane.WARNING_MESSAGE, icon);
            }
        }
        
        if (jogo.getPontuacao() > 0) {
            JOptionPane.showMessageDialog(null, "Fim do Jogo. Pontuação: " + jogo.getPontuacao(),
                    "Palavras Embaralhadas do Gz!", JOptionPane.INFORMATION_MESSAGE, icon);
        } else {
            JOptionPane.showMessageDialog(null, "Fim do Jogo. Você perdeu todas as vidas!",
                    "Palavras Embaralhadas do Gz!", JOptionPane.ERROR_MESSAGE, icon);
            JOptionPane.showMessageDialog(null, "A palavra era: " + jogo.getPalavraNormal(),
                    "Palavras Embaralhadas do Gz!", JOptionPane.WARNING_MESSAGE, icon);
        }
    }
}
