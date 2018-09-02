package springbootmongo.demo.service;

import springbootmongo.demo.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User users);

    User findUserByName(String name);

    void removeUser(String name);

    void updateUser(String name, String key, String value);

    List<User> listUser();

    User getByRepository(String name);

    List<User> getListByRepository(String regexp);

    List<User> getListByRepositoryBetween(int minAge, int maxAge);

//    List<User> getListLikeAndOrder(String name);

    User getUserByName(String name);
}
