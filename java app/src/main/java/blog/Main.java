package blog;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws UnknownHostException {
        final MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost"));
        final DB weather = mongoClient.getDB("weather");
        DBCollection data = weather.getCollection("data");
        final DBCursor cursor = data.find();
        while (cursor.hasNext()) {
            final DBObject doc = cursor.next();
            System.out.println(doc);
        }
    }
}
