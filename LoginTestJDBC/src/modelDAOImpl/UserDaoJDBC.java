package modelDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DB;
import db.DbException;
import modelDAO.UserDAO;
import modelEntities.User;

public class UserDaoJDBC implements UserDAO {

	Connection conn = null;

	public UserDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean login(String login, String password) {

		PreparedStatement pst = null;
		ResultSet rst = null;

		try {
			pst = conn.prepareStatement("SELECT * FROM users WHERE Login = ?");
			pst.setString(1, login);
			rst = pst.executeQuery();

			if (rst.next()) {
				if (rst.getString("Login").equals(login) && rst.getString("Password").equals(password)) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void insert(User user) {

		PreparedStatement pst = null;

		try {
			pst = conn.prepareStatement("INSERT INTO users" + "(Login, Password)" + "VALUES" + "(?, ?)",
					java.sql.Statement.RETURN_GENERATED_KEYS);
			execInsertion(pst, user);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(pst);
		}
	}

	private void execInsertion(PreparedStatement pst, User user) {
		try {
			pst.setString(1, user.getLogin());
			pst.setString(2, user.getPassword());

			int rowsAffected = pst.executeUpdate();
			if (rowsAffected > 0) {
				ResultSet rst = pst.getGeneratedKeys();
				if (rst.next()) {
					int id = rst.getInt(1);
					user.setId(id);
				}
			} else {
				throw new DbException("Unexpected Error, No Rows Affected");
			}

			System.out.println("New User Id = " + user.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
