package com.api.book.bootrestbook.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

    public final String UPLOAD_DIR = "C:\\Users\\umerq\\Documents\\SpringBootProjects\\RestApi's\\bootrestbook\\src\\main\\resources\\static\\images";

    public boolean uploadFile(MultipartFile multipartFile) {
        boolean isUpload = false;
        try {

            // InputStream is = multipartFile.getInputStream();
            // byte data[] = new byte[is.available()];
            // // Reading the file
            // is.read(data);
            // // Now writing the file data
            // // FileOutputStream fos = new
            // // FileOutputStream(UPLOAD_DIR+"\\"+multipartFile.getOriginalFilename());
            // FileOutputStream fos = new FileOutputStream(
            //         UPLOAD_DIR + File.separator + multipartFile.getOriginalFilename());
            // fos.write(data);
            // fos.flush();
            // fos.close();




            //We can also do it with  with this way

            Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
            isUpload = true;

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return isUpload;
    }
}
