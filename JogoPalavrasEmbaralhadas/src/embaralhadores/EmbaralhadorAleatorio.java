package embaralhadores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import src.Embaralhador;

public class EmbaralhadorAleatorio implements Embaralhador {

	@Override
	public String embaralhada(String palavra) {
		
		List<Character> letras = new ArrayList<>();
		
		for(char c : palavra.toCharArray()) {
			letras.add(c);
		}
		
		Collections.shuffle(letras);
		StringBuilder palavraEmbaralhadaAleatoriamente = new StringBuilder();
		
		for (char c : letras) {
			palavraEmbaralhadaAleatoriamente.append(c);
		}
		
		return palavraEmbaralhadaAleatoriamente.toString();
		
	}

}
