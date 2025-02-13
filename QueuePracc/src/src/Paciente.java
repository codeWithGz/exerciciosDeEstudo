package src;

public class Paciente {
	private int id;
	private String name;
	
	Paciente(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	protected int getId() {
		return id;
	}

	protected String getName() {
		return name;
	}

	
	
	
	
	
	
	
//	
//	FilaDeEspera pacientesEsperando = new FilaDeEspera();
//	pacientesEsperando.adicionarPaciente(1, "Verificar");
//	pacientesEsperando.adicionarPaciente(2, "VerificarDNV");
//
//	pacientesEsperando.getListaDeEspera();
//	
//	System.out.println("======================================");
//	pacientesEsperando.procurarPacientePorId(1);
//	
//	System.out.println("======================================");
//	
//	pacientesEsperando.chamarProximoPaciente();
//	pacientesEsperando.chamarProximoPaciente();
	
}
