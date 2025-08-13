package application;

import javax.swing.JOptionPane;

import modelDAO.DaoFactory;
import modelDAO.UserDAO;
import modelEntities.User;

public class App {

	public static void main(String[] args) {

		UserDAO userDAO = DaoFactory.createUserDao();

		Integer option = Integer.parseInt(JOptionPane.showInputDialog(null, "1- Create New User\n" + "2- Login",
				"Choose an Option", JOptionPane.QUESTION_MESSAGE));

		switch (option) {
		case 1:
			String login = JOptionPane.showInputDialog("Type your login");
			String password = JOptionPane.showInputDialog("Type your password");
			User register = new User(null, login, password);
			userDAO.insert(register);
			JOptionPane.showMessageDialog(null, "New User: " + register);
			
			break;
		case 2:
			login = JOptionPane.showInputDialog(null, "Enter your login", "Login", JOptionPane.PLAIN_MESSAGE);
			password = JOptionPane.showInputDialog(null, "Enter your password", "Login", JOptionPane.PLAIN_MESSAGE);

			String msg = userDAO.login(login, password) ? "Logged In" : "Login or Password Invalid";
			JOptionPane.showMessageDialog(null, msg);

			break;
		default:
			throw new IllegalArgumentException("Unexpected Value: " + option);
		}
	}

}
