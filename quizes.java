
 
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.util.ArrayList;
import java.util.List;
 
import org.bson.Document;
 
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BSONObject;
 
public class quizes {
 
	public static void main(String[] args) {
 
		MongoClient client = new MongoClient();
		MongoDatabase database = client.getDatabase("foray");
		MongoCollection<Document> collection = database
				.getCollection("temple");

           
		List<Document> temples = (List<Document>) collection.find().into(
				new ArrayList<Document>());
                       
                              
		for (Document temple : temples) {
                      

			
                                    System.out.println("name:"+ temple.getString("name"));
                               
                }
 
	}
}