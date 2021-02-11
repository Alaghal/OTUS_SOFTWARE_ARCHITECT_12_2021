package otus.seryakov.myapp.service;

import otus.seryakov.myapp.model.User;

import java.util.List;

public interface UserService {

    boolean addUser(User user);

    boolean deleteUser(long id);

    boolean updateUsers(User user);

    User getUserById(long id);

    List<User> getAllUsers();
}
