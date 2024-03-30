package com.example.demo.gmailController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.starterClass;
import com.example.demo.Service.gmailService;
import com.example.demo.repository.DeletedGmailRepository;

@RestController
@RequestMapping("/api/gmails")
public class gmailController {

	gmailService gmailservice;
	

	public gmailController(gmailService gmailservice) {
		this.gmailservice = gmailservice;
	}

	// POST MAPPING
	@CrossOrigin(origins = { "*" })
	@PostMapping("/save")
	public ResponseEntity<?> saveGmail(@RequestBody starterClass startclass) {
		return gmailservice.SaveGmail(startclass);
		// return new ResponseEntity<>("Gmail Saved successfully", HttpStatus.CREATED);
	}

	// GET MAPPING
	@CrossOrigin(origins = { "*" })
	@GetMapping("{gmailId}")
	public  starterClass getGmaildetails(@PathVariable("gmailId") int gmailId) {
		return gmailservice.getGmail(gmailId);
	}

	@CrossOrigin(origins = { "*" })
	@GetMapping("/All")
	public ResponseDTO getAllGmail() {
		return gmailservice.getAllGmail();
	}

	// PUT MAPPING
	@CrossOrigin(origins = { "*" })
	@PutMapping("/update")
	public String updatethevalues(@RequestBody starterClass starterClass) {
		gmailservice.updategmail(starterClass);
		return "updated  successfully.....";
	}

	@CrossOrigin(origins = { "*" })
	@PutMapping("/read/{gmailId}")
	public ResponseEntity<?> read(@PathVariable int gmailId) {
	    ResponseDTO result = gmailservice.Read1(gmailId, true);
	    String message = result.getMessage();
	    if (message != null && message.contains("successfully")) {
	        return new ResponseEntity<>(result, HttpStatus.OK);
	    } 
	    else {
	        return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
	    }
	}


	@CrossOrigin(origins = { "*" })
	@PutMapping("/unread/{gmailId}")
	public ResponseEntity<ResponseDTO> unread(@PathVariable int gmailId) {
	    ResponseDTO result = gmailservice.UnRead1(gmailId, false);
	    String message = result.getMessage();

	    if (message != null && message.contains("Sucessfull ")) {
	        // Condition for a successful operation based on the message containing "someSubstring"
	        return new ResponseEntity<>(result, HttpStatus.OK);
	    } else {
	        // General condition based on isSuccess() or other cases
	        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
	    }
	}

	// DELETE MAPPING
	@CrossOrigin(origins = { "*" })
	@DeleteMapping("{gmailId}")
	public String deleteDetails(@PathVariable("gmailId") int gmailId) {
		gmailservice.deleteGmail(gmailId);
		return "Gmail Delete successfully";
	}
	
	@CrossOrigin(origins = { "*" })
	@GetMapping("/DelAll")
	public ResponseDTO getDeleteAllGmail() {
		return gmailservice.getDeleteAllGmail();
	}
	

}
