package beer.app.mongo;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class DatabaseMethods {

	private static final Logger log = LoggerFactory.getLogger(DatabaseMethods.class);
	protected DB db;

	public DatabaseMethods() {
		initDbConnection();
	}

	protected void initDbConnection() {
		try {
			MongoClient mongoClient = new MongoClient("localhost");
			this.db = mongoClient.getDB("mydb");

		} catch (UnknownHostException e) {
			log.error("Create Mongo Client failed.", e);
		}
	}

	public DBCollection getCollection(String name) {
		DBCollection collection;
		if (this.db.collectionExists(name)) {
			collection = this.db.getCollection(name);
		} else {
			DBObject options = BasicDBObjectBuilder.start().add("capped", Boolean.TRUE)
					.add("size", Long.valueOf(2000000000l)).get();
			collection = this.db.createCollection(name, options);
		}
		return collection;
	}

	public void addDocument(DBCollection col) {
		BasicDBObject b1 = new BasicDBObject("name", "Mikkeller").append("type", "IS")
				.append("count", Integer.valueOf(1))
				.append("info", new BasicDBObject("x", Integer.valueOf(103)).append("y", Integer.valueOf(102)));
		col.insert(b1);
		BasicDBObject b2 = new BasicDBObject("name", "BrewDog").append("type", "IPA")
				.append("count", Integer.valueOf(1))
				.append("info", new BasicDBObject("x", Integer.valueOf(203)).append("y", Integer.valueOf(102)));
		col.insert(b2);
		log.info("Documents added.");
	}

	public void getCollectionNames() {
		Set<String> colls = this.db.getCollectionNames();

		for (String s : colls) {
			System.out.println("Collection:" + s);
		}
	}

	public void readDocument(DBCollection col) {
		BasicDBObject query = new BasicDBObject("name", "Mikkeller");

		List<String> list = new ArrayList<>();
		list.add("Mikkeller");
		list.add("BrewDog");
		query.put("name", new BasicDBObject("$in", list));

		try (DBCursor cursor = col.find(query)) {
			while (cursor.hasNext()) {
				System.out.println("Read document: " + cursor.next());
			}
		}
	}

	public void updateDocument(DBCollection col) {
		BasicDBObject newDocument = new BasicDBObject();
		newDocument.append("$set", new BasicDBObject().append("type", "DIPA"));

		BasicDBObject query = new BasicDBObject("name", "BrewDog");

		col.update(query, newDocument);

	}
}
