package modelDAO;


import modelEntities.User;

public interface UserDAO {

	boolean login(String login, String password);
	void insert(User user);
	
}
