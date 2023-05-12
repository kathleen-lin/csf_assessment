package ibf2022.batch2.csf.backend.repositories;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import ibf2022.batch2.csf.backend.models.Bundle;

public class ArchiveRepository {

	private String MONGO_COLLECTION="archives";

	@Autowired
	private MongoTemplate mongoTemplate;

	//TODO: Task 4
	// You are free to change the parameter and the return type
	// Do not change the method's name
	// Write the native mongo query that you will be using in this method
	//
	/*db.archives.find({
    "bundleId" : <bundleId>,
    "date" : <upload date>,
    "title": "<title>",
    "name": "<name>",
    "comments": "<comments>",
    "urls": []",
	})
*/
	public Object recordBundle(String bundleId, String name, String title, String comments) {
		
		Bundle b = new Bundle();
		b.setBundleId(bundleId);
		b.setDate(Date.from(Instant.now()));
		b.setTitle(title);
		b.setName(name);
		b.setComments(comments);
		Document toAdd = b.toDocument();	
		mongoTemplate.insert(toAdd, MONGO_COLLECTION);	
		
		return null;
	}

	//TODO: Task 5
	// You are free to change the parameter and the return type
	// Do not change the method's name
	// Write the native mongo query that you will be using in this method
	//
	//
	public Object getBundleByBundleId(/* any number of parameters here */) {
		return null;
	}

	//TODO: Task 6
	// You are free to change the parameter and the return type
	// Do not change the method's name
	// Write the native mongo query that you will be using in this method
	//
	//
	public Object getBundles(/* any number of parameters here */) {
		return null;
	}


}
