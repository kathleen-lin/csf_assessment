package ibf2022.batch2.csf.backend.repositories;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.swing.text.html.Option;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.lang.Nullable;

import ibf2022.batch2.csf.backend.models.Bundle;

@Repository
public class ArchiveRepository {

	private String MONGO_COLLECTION="archives";

	@Autowired
	private MongoTemplate mongoTemplate;

	//TODO: Task 4
	// You are free to change the parameter and the return type
	// Do not change the method's name
	// Write the native mongo query that you will be using in this method
	//

	/*
	db.archives.insert({
    "bundleId" : <bundleId>,
    "date" : <upload date>,
    "title": "<title>",
    "name": "<name>",
    "comments": "<comments>",
    "urls": []",
	})
*/
	public void recordBundle(String bundleId, String name, String title, String comments) {
		
		Bundle b = new Bundle();
		b.setBundleId(bundleId);
		b.setDate(Date.from(Instant.now()));
		b.setTitle(title);
		b.setName(name);
		b.setComments(comments);
		Document toAdd = b.toDocument();	
		mongoTemplate.insert(toAdd, MONGO_COLLECTION);	
		
	}

	//TODO: Task 5
	// You are free to change the parameter and the return type
	// Do not change the method's name
	// Write the native mongo query that you will be using in this method
	// 
	
	/*
	db.archives.findOne({
		bundleId: 1
	})
	*/

	public Optional<Document> getBundleByBundleId(String bundleId) {
		Criteria criterial = Criteria.where("bundleId").is(bundleId);
		Query query = Query.query(criterial);


		return Optional.ofNullable(mongoTemplate.findOne(query, Document.class,MONGO_COLLECTION));
		
	}

	//TODO: Task 6
	// You are free to change the parameter and the return type
	// Do not change the method's name
	// Write the native mongo query that you will be using in this method
	//
	//db.archives.find({})
	public Optional<List<Document>> getBundles() {
		
		return Optional.ofNullable(mongoTemplate.findAll(Document.class, MONGO_COLLECTION));
		
	}


}
