package Service;

import java.util.List;

import javax.ejb.Local;

import Domain.User;




@Local
public interface UserServiceLocal {
	void createUser(User user);
	void updateUser(User user);
	void deleteUser(User user);
	List<User> findAllUsers();
	User authenticate(String login, String password);
	boolean loginExists(String login);
	User findUserByLogin(String login);
}
