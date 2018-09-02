package springbootmongo.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import springbootmongo.demo.model.User;
import springbootmongo.demo.repository.UserRepository;
import springbootmongo.demo.service.UserService;

import java.util.List;

@Component("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    UserRepository userRepository;

    @Override
    public void saveUser(User users) {
        mongoTemplate.save(users);
    }

    @Override
    public User findUserByName(String name) {
        return mongoTemplate.findOne(
                new Query(Criteria.where("name").is(name)), User.class);
    }

    @Override
    public void removeUser(String name) {
        mongoTemplate.remove(
                new Query(Criteria.where("name").is(name)), User.class);
    }

    @Override
    public void updateUser(String name, String key, String value) {
        mongoTemplate.updateFirst(
                new Query(Criteria.where("name").is(name)), Update.update(key, value), User.class
        );
    }

    @Override
    public List<User> listUser() {
        return mongoTemplate.findAll(User.class);
    }

    @Override
    public User getByRepository(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public List<User> getListByRepository(String regexp) {
        return userRepository.findByNameStartingWith(regexp);
    }

    @Override
    public List<User> getListByRepositoryBetween(int minAge, int maxAge) {
        return userRepository.findByAgeBetween(minAge, maxAge);
    }

//    @Override
//    public List<User> getListLikeAndOrder(String name) {
//        return userRepository.findByNameLikeOrderByAgeAgeAsc(name);
//    }


    @Override
    public User getUserByName(String name) {
        return userRepository.findUserByName(name);
    }
}
