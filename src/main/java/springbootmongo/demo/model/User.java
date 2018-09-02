package springbootmongo.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigInteger;

@Document(collection = "user")
@CompoundIndexes({
        @CompoundIndex(name = "age_idx", def = "{'name': 1, 'age': -1}")
})
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private BigInteger id;
    @Indexed
    private String uid;
    @Indexed(unique = true)
    private String name;
    private int age;
    @Transient
    private String address;

}
