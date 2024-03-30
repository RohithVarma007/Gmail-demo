package com.example.demo.helper;

import java.io.FileOutputStream;
import java.io.InputStream;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class fileUploadHelper {

	public final String UPLOAD_DIR = "C:\\Users\\Rohith Varma\\Documents\\salaarpic";

	public boolean uploadFile(MultipartFile multiPartFile) {
		boolean f = false;
		try {
			InputStream stream = multiPartFile.getInputStream();
			byte data[] = new byte[stream.available()];
			stream.read();
			FileOutputStream fos = new FileOutputStream(UPLOAD_DIR + "\\" + multiPartFile.getOriginalFilename());
			fos.write(data);
			fos.flush();
			fos.close();
			
		//	Files.copy(multiPartFile.getInputStream(),Paths.get("D:\\newws\\gmailDemo\\src\\main\\resources\\static\\image"),StandardCopyOption.REPLACE_EXISTING);
			
			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
}
