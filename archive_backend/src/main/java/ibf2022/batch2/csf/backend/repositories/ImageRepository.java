package ibf2022.batch2.csf.backend.repositories;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Repository
public class ImageRepository {

	//TODO: Task 3
	// You are free to change the parameter and the return type
	// Do not change the method's name
	
	@Autowired
	private AmazonS3 s3;
	
	public void upload(List<File> images, String name, String title, String comments) {

		Map<String, String> userData = new HashMap<>();

		userData.put("name", name);
		userData.put("title", title);
		userData.put("comments", comments);

		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setUserMetadata(userData);
		
		for (File i: images){

			PutObjectRequest putReq;

			try {
				putReq = new PutObjectRequest("kathleen", i.getName(), new FileInputStream(i), metadata);
				putReq = putReq.withCannedAcl(CannedAccessControlList.PublicRead);
				s3.putObject(putReq);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		
		}

	}
}
