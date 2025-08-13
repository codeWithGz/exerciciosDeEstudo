package modelDAO;

import db.DB;
import modelDAOImpl.UserDaoJDBC;


public class DaoFactory {
	
	public static UserDAO createUserDao() {
		return new UserDaoJDBC(DB.getConnection());
	}
	

}
