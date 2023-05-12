package ibf2022.batch2.csf.backend.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import ibf2022.batch2.csf.backend.repositories.ArchiveRepository;
import ibf2022.batch2.csf.backend.services.imageService;

@Controller
@RequestMapping("/api")
public class UploadController {

	@Autowired
	private imageService imgSvc;

	@Autowired
	private ArchiveRepository arcRepo;

	// TODO: Task 2, Task 3, Task 4
	@PostMapping(path = "/upload", consumes =MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> postImages (@RequestPart MultipartFile archive, 
												@RequestPart String name,@RequestPart String title, @RequestPart String comments){

		
		try {
			// use a service
			imgSvc.uploadZipFile(archive, name, title, comments);
			String bundleId = UUID.randomUUID().toString().substring(0, 8);
			arcRepo.recordBundle(bundleId, name, title, comments);
			String body = "bundleId:" + bundleId;
			return new ResponseEntity<String>(body, HttpStatus.CREATED);
														
		} catch (Exception e) {
			String body = "error:" + e.toString();

			return new ResponseEntity<String>(body, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	} 

	// TODO: Task 5
	

	// TODO: Task 6

}
