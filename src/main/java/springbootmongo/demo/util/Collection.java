package springbootmongo.demo.util;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.context.annotation.Configuration;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Configuration
public class Collection {
    private volatile static com.mongodb.client.MongoCollection<Document> mongoCollection = null;


    public static com.mongodb.client.MongoCollection<Document> getMongoCollection(String dbName, String cname) {
        if (mongoCollection == null) {
            synchronized (com.mongodb.client.MongoCollection.class) {
                if (mongoCollection == null) {
                    MongoClient mongoClient = MongoClients.create("mongodb://127.0.0.1:27017");
                    MongoDatabase mongoDatabase = mongoClient.getDatabase(dbName);
                    mongoCollection = mongoDatabase.getCollection(cname);
                }
            }
        }
        return mongoCollection;
    }
}
