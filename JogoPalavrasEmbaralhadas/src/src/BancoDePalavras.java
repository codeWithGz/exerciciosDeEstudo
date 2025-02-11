package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class BancoDePalavras {
    private List<String> palavras;

    public BancoDePalavras(InputStream arquivoStream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(arquivoStream))) {
            palavras = reader.lines().collect(Collectors.toList());
        } catch (Exception e) {
            palavras = Arrays.asList("exemplo", "palavra", "teste"); // Palavras padrão em caso de erro
        }
    }

    public String getPalavraAleatoria() {
        Random random = new Random();
        return palavras.get(random.nextInt(palavras.size()));
    }
    
    public List<String> getTodasPalavras() {
        return Collections.unmodifiableList(palavras);
    }
}
