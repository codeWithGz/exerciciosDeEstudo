package src;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import mecanicasDeJogo.MecanicaFacil;
import mecanicasDeJogo.MecanicaMedia;
import mecanicasDeJogo.MecanicaDificil;

class FabricaMecanicaDoJogo {
    private static final List<Class<? extends MecanicaDoJogo>> MECANICAS = Arrays.asList(
            MecanicaFacil.class, MecanicaMedia.class, MecanicaDificil.class
    );

    public static MecanicaDoJogo getMecanica(BancoDePalavras banco) {
        Random random = new Random();
        int escolha = random.nextInt(MECANICAS.size());

        try {
            return MECANICAS.get(escolha).getDeclaredConstructor(BancoDePalavras.class).newInstance(banco);
        } catch (Exception e) {
            e.printStackTrace();
            return new MecanicaFacil(banco); 
        }
    }
}
