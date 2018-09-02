package springbootmongo.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springbootmongo.demo.model.User;
import springbootmongo.demo.service.UserService;
import springbootmongo.demo.util.MongoUtil;
import sun.jvm.hotspot.gc_implementation.parallelScavenge.PSYoungGen;

import java.security.PublicKey;
import java.util.List;

@RestController("user")
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    MongoUtil mongoUtil;

    @PostMapping("/add")
    public void add(@RequestBody User user) {
        userService.saveUser(user);
    }

    @GetMapping("/getOne")
    public User getOne(String name) {
        return userService.findUserByName(name);
    }

    @DeleteMapping("/delete")
    public void delete(String name) {
        userService.removeUser(name);
    }

    @PutMapping("/update")
    public void update(String name, String key, String value) {
        userService.updateUser(name, key, value);
    }

    @GetMapping("/list")
    public List<User> list() {
        return userService.listUser();
    }

    @GetMapping("/getByRepository")
    public User getByRepository(String name) {
        return userService.getByRepository(name);
    }

    @GetMapping("/getListByRepository")
    public List<User> getListByRepository(String name) {
        return userService.getListByRepository(name);
    }

    @GetMapping("/getListByRepositoryBetween")
    public List<User> getListByRepositoryBetween(int minAge, int maxAge) {
        return userService.getListByRepositoryBetween(minAge, maxAge);
    }

//    @GetMapping("/getListLikeAndOrder")
//    public List<User> getListLikeAndOrder(String name) {
//        return userService.getListLikeAndOrder(name);
//    }

    @GetMapping("/getListByQuery")
    public User getListByQuery(String name) {
        return userService.getUserByName(name);
    }

    @PostMapping("/addByOriAPI")
    public void addByOriAPI() {
        mongoUtil.insertOne();
    }

    @PostMapping("/addManyByOriAPI")
    public void addManyByOriAPI() {
        mongoUtil.insertMany();
    }

    @PostMapping("/replaceOneByOriAPI")
    public void replaceOneByOriAPI() {
        mongoUtil.updateOne();
    }
}
