package beer.app.mongo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.DBCollection;

public class App 
{
    private static final Logger log = LoggerFactory.getLogger(App.class);
    protected DatabaseMethods db;
    private static App instance;
    
	public static void main( String[] args )
    {
		instance = new App();
		instance.db = new DatabaseMethods();
		DBCollection col = instance.db.getCollection("testCol");
		//instance.db.getCollectionNames();
		instance.db.addDocument(col);
		instance.db.readDocument(col);
		instance.db.updateDocument(col);
		instance.db.readDocument(col);
		
    }
	

}
