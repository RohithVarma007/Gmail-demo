package com.example.demo.gmailController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.helper.fileUploadHelper;

@RestController
public class FileUploadController {

	@Autowired
	private fileUploadHelper fileuploadhelper;

	@PutMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {

		try {
			if (file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request Must Contain File...");
			}
			if (!file.getContentType().equals("image/jpeg")) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.body("ONLY JPEG CONTEXT TYPE IS ALLOWED");
			}

			boolean f = fileuploadhelper.uploadFile(file);

			if (f) {
				return ResponseEntity.ok("FILE IS SUCESSFULLY UPLOADED ");
			}

		} catch (Exception e) {
			e.getStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Some Went Wrong ! Please Try Again ");
	}
}

//System.out.println(file.getSize());
//System.out.println(file.getOriginalFilename());
//System.out.println(file.getContentType());
//System.out.println(file.getName());