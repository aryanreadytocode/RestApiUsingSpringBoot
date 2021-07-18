package com.aryan.spring.bootrestbook.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
    public final String UPLOAD_DIR = "D:\\Aryan_Projects\\boot\\bootrestbook\\src\\main\\resources\\static\\image";

    public boolean uploadFile(MultipartFile multipartFile) {
        boolean f = false;

        try {

            // InputStream is = multipartFile.getInputStream();
            // byte bytes[] = new byte[is.available()];

            // is.read(bytes);

            // //write
            // FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename();
            // fos.write(bytes);
            // fos.close();
            // fos.close();
            // f = true;

            Files.copy(multipartFile.getInputStream(),  
            Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()), 
            StandardCopyOption.REPLACE_EXISTING);
            f = true;


        } catch(Exception exception) {
            exception.printStackTrace();
        }

        return f;
    }
}
