package exercicios;

import javax.swing.JOptionPane;

public class ExVetoresHotel {
	
	
	private String name;
	private String email;
	private int room;
	
	public ExVetoresHotel(String name, String email, int room) {
		this.name = name;
		this.email = email;
		this.room = room;
	}
	
	protected void setName(String name) {
		this.name = name;
	}

	protected void setEmail(String email) {
		this.email = email;
	}
	
	protected void setRoom(int room) {
		this.room = room;
	}
	
	public String toString() {
		return "Name: " + this.name + "\nEmail: " + this.email + "\nRoom: " + this.room;
	}
	
	public static void main(String[] args) {
		int rentedRooms = Integer.parseInt(JOptionPane.showInputDialog("How many rooms will be rented?"));
		ExVetoresHotel[] toRentRooms = new ExVetoresHotel[10];
		
		for (int i = 1; i <= rentedRooms; i++) {
			String name = JOptionPane.showInputDialog(null, "Name", "Rent #"+i, JOptionPane.QUESTION_MESSAGE);
			String email = JOptionPane.showInputDialog(null, "Email", "Rent #"+i, JOptionPane.QUESTION_MESSAGE);
			int roomNum = Integer.parseInt(JOptionPane.showInputDialog(null, "Room", "Rent #"+i, JOptionPane.QUESTION_MESSAGE));
			
			toRentRooms[roomNum] = new ExVetoresHotel(name, email, roomNum);

			
		}
		
		for(ExVetoresHotel room : toRentRooms) {
			if (room != null) {
				JOptionPane.showMessageDialog(null, room);
				
			}
		}
				
	}

}
