package springbootmongo.demo.util;

import com.mongodb.client.MongoCollection;

import org.bson.Document;
import org.springframework.context.annotation.Configuration;
import springbootmongo.demo.model.User;

import java.util.ArrayList;
import java.util.List;


import static com.mongodb.client.model.Filters.*;



@Configuration
public class MongoUtil {

    MongoCollection mongoCollection = Collection.getMongoCollection("test", "user");

    public void insertOne() {
        Document doc = new Document("name", "testUser11")
                .append("uid", "aret1324123")
                .append("age", 17)
                .append("address", "XA");
        mongoCollection.insertOne(doc);
    }

    public void insertMany() {
        List<Document> docs = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            docs.add(new Document("name", i));
        }
        mongoCollection.insertMany(docs);
    }

    public void updateOne() {
        User user = new User();
        user.setName("updateUser");
        user.setAge(16);
        user.setAddress("BJ");
        user.setUid("a34");
        mongoCollection.replaceOne(eq("name","testUser11"), user);
    }
}
