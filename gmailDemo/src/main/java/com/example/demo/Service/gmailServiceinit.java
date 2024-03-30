package com.example.demo.Service;

import java.security.Timestamp;
import java.util.List;
import java.util.Optional;
import java.sql.*;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.DeletedGmail;
import com.example.demo.starterClass;
import com.example.demo.gmailController.ResponseDTO;
import com.example.demo.repository.DeletedGmailRepository;
import com.example.demo.repository.gmailRepository;

import jakarta.transaction.Transactional;

@Service
public class gmailServiceinit implements gmailService {

	private static final int ResponseEntity = 0;
	gmailRepository gmailRepository;

	private  DeletedGmailRepository deletedGmailRepository;

	@Autowired
	public gmailServiceinit(gmailRepository gmailRepository, DeletedGmailRepository deletedGmailRepository) {
		this.gmailRepository = gmailRepository;
		this.deletedGmailRepository = deletedGmailRepository;
	}

	@Override
	@Transactional
	public ResponseEntity<?> SaveGmail(starterClass startclass) {
		ResponseEntity<?> resp = null;
		System.out.println("startclass" + startclass);

		starterClass save = gmailRepository.save(startclass);
		if (save != null && save.getGmailid() > 0) {
			return new ResponseEntity<>("Gmail Saved successfully", HttpStatus.CREATED);

		} else {
			return resp;
		}
	}

	@Override
	public String updategmail(starterClass startclass) {
		gmailRepository.save(startclass);
		return "Your Gmail is updated...";
	}


	@Override
	public starterClass getGmail(int gmailId) {

		return gmailRepository.findById(gmailId).get();
	}

	@Override
	public ResponseDTO getAllGmail() {
		List<starterClass> findAll = gmailRepository.findAll();
		ResponseDTO dto = new ResponseDTO(true, findAll, " Your Get Method is Executed !");
		return dto;
	}
	
	@Override
	public ResponseDTO Read1(int gmailId, boolean b) {
		Optional<starterClass> read1 = gmailRepository.findById(gmailId);

		if (read1.isPresent()) {
			starterClass getRead = read1.get();
			if (b) {
				getRead.setRead(true);
				gmailRepository.save(getRead);
			} else {
				return new ResponseDTO(false, read1, " Read Method is not correct !");
			}

			ResponseDTO dto = new ResponseDTO(true, read1, " Read Method is called ! ");
			return dto;
		} else {
			return new ResponseDTO(false, read1, " Sorry Read Method is not called ! ");
		}
	}


	@Override
	public ResponseDTO UnRead1(int gmailId, boolean b) {
		Optional<starterClass> Unread1 = gmailRepository.findById(gmailId);

		if (Unread1.isPresent()) {
			starterClass getRead = Unread1.get();
			if (!b) {
				getRead.setRead(false);
				gmailRepository.save(getRead);
			} else {
				return new ResponseDTO(false, Unread1, " UnRead Method is not correct !");
			}

			ResponseDTO dto = new ResponseDTO(true, Unread1, " UnRead Method is called ! ");
			return dto;
		} else {
			return new ResponseDTO(false, Unread1, " Sorry UnRead Method is not called ! ");
		}
		
	
		}
	
	@Override
	public ResponseDTO getDeleteAllGmail() {
		List<DeletedGmail> deleteAll = deletedGmailRepository.findAll();
		ResponseDTO dto = new ResponseDTO(true,deleteAll,"Your delted method is excuted");
		return dto;
	}
	@Override
	public String deleteGmail(int gmailId) {
		try {
			starterClass gmailToDelete = gmailRepository.findById(gmailId).orElse(null);

			if (gmailToDelete != null) {
				gmailRepository.deleteById(gmailId);
				 logDeletedGmail(gmailToDelete);
				return "Your Mail with ID " + gmailId + " is Deleted...";
			} else {
				return "Mail with ID " + gmailId + " not found. Deletion failed.";
			}
		} catch (Exception e) {
			// Log or print the exception
			e.printStackTrace();
			return "Error occurred during deletion: " + e.getMessage();
		}
	}
	
	 private void logDeletedGmail(starterClass deletedGmail) {
	        // Your logic to log deleted Gmail data using deletedGmailRepository...
	        DeletedGmail deletedGmailEntity = new DeletedGmail();
	        deletedGmailEntity.setGmailId(deletedGmail.getGmailid());
	        //deletedGmailEntity.setDeletionTimestamp(Instant.now());
	        deletedGmailEntity.setGmailTitle(deletedGmail.getGmailTitle());
	        deletedGmailEntity.setGmailDescription(deletedGmail.getGmailDescription());
	        deletedGmailRepository.save(deletedGmailEntity);
	    }
}
	
//	@Override
//	public ResponseDTO getAllGmail() {
//		List<starterClass> findAll = gmailRepository.findAll();
//		ResponseDTO dto = new ResponseDTO(true, findAll, " Your Get Method is Executed !");
//		return dto;
//	}
	
	/*
	 * @Override public String Read(int gmailId, boolean b) { Optional<starterClass>
	 * classOptional = gmailRepository.findById(gmailId);
	 * 
	 * if (classOptional.isPresent()) { starterClass gmail = classOptional.get(); if
	 * (b) {
	 * 
	 * gmail.setRead(true); gmailRepository.save(gmail); return
	 * "Your Gmail with ID " + gmailId + " is marked as read."; } else { return
	 * "Your Gmail with ID " + gmailId + " is not read."; } } else { return
	 * "Gmail with ID " + gmailId + " not found."; } }
	 */

	/*
	 * @Override public String UnRead(int gmailId, boolean b) {
	 * Optional<starterClass> op = gmailRepository.findById(gmailId); if
	 * (op.isPresent()) { starterClass gmail = op.get(); if (!b) {
	 * gmail.setunread(false); gmailRepository.save(gmail); return
	 * "Your Gmail with ID " + gmailId + " has changed to false"; } else { return
	 * "Your Gmail with ID " + gmailId + " is not Changed."; } } else { return
	 * "Gmail with ID " + gmailId + " not found "; } }
	 */
