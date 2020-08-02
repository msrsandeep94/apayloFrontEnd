package apayloUtilities;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import org.bson.Document;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class DatabaseConnection {

	static String host, dbname, user, password,databasename;
	static MongoDatabase db; 
	static MongoClient mongoClient ;

	public void mongoDbConnection() {
		try {

			Properties prop = new Properties();
			prop.load(new FileInputStream(System.getProperty("user.dir") + "/configs/configurations.properties"));

			host = prop.getProperty("host").toString();
			dbname = prop.getProperty("dbname").toString();
			user = prop.getProperty("user").toString();
			password = prop.getProperty("password").toString();
			databasename=prop.getProperty("databasename").toString();

			System.out.println("host: " + host + "\ndbname: " + dbname + "\nuser: " + user + "\npassword: " + password);

			MongoCredential credential = MongoCredential.createCredential(user, dbname, password.toCharArray());
			mongoClient = new MongoClient(new ServerAddress(host), Arrays.asList(credential));
			System.out.println(mongoClient.getConnectPoint());

			db = mongoClient.getDatabase(databasename);

		} catch (IOException ex) {
		}
	}

	public String getdocId(String sol_id,String tablename)
    {
          
        String doc_id=null;
        try {
            
            MongoCollection<Document> collection=db.getCollection(tablename);
            
            List<Document> documents = (List<Document>) collection.find(Filters.eq("solution_id", sol_id)).sort(new BasicDBObject("updated_ts", -1)).into(new ArrayList<Document>());
            for (Document document : documents) {
                if(document.get("solution_id").toString().equalsIgnoreCase(sol_id))
                {
                    System.out.println(document.get("doc_id").toString());
                    doc_id=document.get("doc_id").toString();
                    closeConnection();
                    break;
                }

            }
            
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return doc_id;
    }
	
	public void closeConnection()
	{
		mongoClient.close();
	}

}