package ibf2022.batch2.csf.backend.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ibf2022.batch2.csf.backend.repositories.ImageRepository;

@Service
public class imageService {

    @Autowired
    private ImageRepository imgRepo;
    
    public void uploadZipFile (MultipartFile fileZip, String name, String title, String comments) throws IOException{

        List<File> imagesToUpload = new LinkedList<>();    
        ZipInputStream zis = new ZipInputStream(fileZip.getInputStream());
        ZipEntry zipEntry = zis.getNextEntry();
            while (zipEntry != null) {
                String fileName = zipEntry.getName();
                File destFile = new File("src/main/java/inf2022/batch2/csf/backend/resources/temp", fileName);
                FileOutputStream fos = new FileOutputStream(destFile);
                byte[] buffer = new byte[1024];
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
                imagesToUpload.add(destFile);
                zipEntry = zis.getNextEntry();

            }
               
            zis.closeEntry();
            zis.close();

            imgRepo.upload(imagesToUpload, name, title, comments);

    }
    
       
}
