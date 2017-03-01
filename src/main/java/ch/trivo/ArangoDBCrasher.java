package ch.trivo;

import com.arangodb.ArangoDBAsync;
import com.arangodb.entity.BaseDocument;

import java.util.Random;

/**
 * Hello world!
 *
 */
public class ArangoDBCrasher
{

    public static String getRandomString() {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String output = sb.toString();
        return output;
    }

    public static void main( String[] args )
    {
        ArangoDBAsync arangoDB = new ArangoDBAsync.Builder().host("172.17.0.2", 8529).user("root").build();
        while(true) {
            BaseDocument doc = new BaseDocument();
            doc.addAttribute("name", getRandomString());
            arangoDB.db("test").collection("testCollection").insertDocument(doc);
        }
    }
}
