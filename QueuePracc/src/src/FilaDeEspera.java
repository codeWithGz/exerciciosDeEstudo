package src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JOptionPane;

public class FilaDeEspera {

	ArrayList<Paciente> listaDePacientes = new ArrayList<>();
	Queue<Paciente> listaDeEspera = new LinkedList<Paciente>(listaDePacientes);
		
	public void adicionarPaciente(int id, String name) {
		Paciente novoPaciente = new Paciente(id, name);
		listaDePacientes.add(novoPaciente);
		listaDeEspera.add(novoPaciente);
	}
	
	public void chamarProximoPaciente() {
		
		if (!listaDeEspera.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Chamando Paciente: " + listaDeEspera.peek().getName());
			listaDeEspera.poll();
		}else {
			JOptionPane.showMessageDialog(null, "Fila Vazia");
		}
	}
	
	public void procurarPacientePorId(int indice) {
	    for (Paciente paciente : listaDeEspera) {
	        if (paciente.getId() == indice) {
	            JOptionPane.showMessageDialog(null, "Paciente encontrado: " + paciente.getName());
	            return;  // Se encontrar o paciente, encerra a busca
	        }
	    }
	    // Caso o paciente não seja encontrado
	    JOptionPane.showMessageDialog(null, "Paciente com ID " + indice + " não encontrado.");
	}

	// Getters 
	public ArrayList<Paciente> getListaDePacientes() {
		return listaDePacientes;
	}

	protected Queue<Paciente> getListaDeEspera() {
		for(Paciente p : listaDeEspera) {
			System.out.println("ID: " + p.getId() + " Nome: " + p.getName());
		}
		return listaDeEspera;
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
