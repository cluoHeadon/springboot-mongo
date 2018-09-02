package springbootmongo.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import springbootmongo.demo.model.User;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    User findByName(String name);

    /**
     * 模糊查询
     *
     * @author
     * @date 2018/9/2
     * @param
     * @return
     */

    List<User> findByNameStartingWith(String regexp);

    List<User> findByAgeBetween(int minAge, int maxAge);

    /**
     * 模糊查询和排序
     *
     * @author
     * @date 2018/9/2
     * @param
     * @return
     */

//    List<User> findByNameLikeOrderByAgeAgeAsc(String name);

    @Query("{ 'name' : ?0}")
    User findUserByName(String name);
}
