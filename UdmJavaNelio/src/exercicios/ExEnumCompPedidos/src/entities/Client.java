package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private String name;
	private String email;
	private Date birthDate;
	
	public Client() {
	}
	
	public Client(String name, String email, Date birthDate) {
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected String getEmail() {
		return email;
	}

	protected void setEmail(String email) {
		this.email = email;
	}

	protected Date getBirthDate() {
		return birthDate;
	}

	protected void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Client: " + name +  " (" + sdf.format(birthDate) + ") - " + email);
		return sb.toString();
	}
	
	
}
