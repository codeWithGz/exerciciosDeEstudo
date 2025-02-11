package embaralhadores;

import src.Embaralhador;

public class EmbaralhadorInvertido implements Embaralhador{

	@Override
	public String embaralhada(String palavra) {
		return new StringBuilder(palavra).reverse().toString();
	}
}
