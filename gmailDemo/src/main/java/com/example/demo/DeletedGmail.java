package com.example.demo;


//import java.time.Instant;
//import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class DeletedGmail {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String gmailTitle;
    
	private String gmailDescription;

    private int gmailId;
    
    //private Instant deletionTimestamp;
    
	public int getGmailId() {
		return gmailId;
	}
	public void setGmailId(int gmailId) {
		this.gmailId = gmailId;
	}
//	public Instant getDeletionTimestamp() {
//		return deletionTimestamp;
//	}
//	public void setDeletionTimestamp(Instant instant) {
//		this.deletionTimestamp = instant;
//	}
	public String getGmailTitle() {
		return gmailTitle;
	}
	public void setGmailTitle(String gmailTitle) {
		this.gmailTitle = gmailTitle;
	}
	public String getGmailDescription() {
		return gmailDescription;
	}
	public void setGmailDescription(String gmailDescription) {
		this.gmailDescription = gmailDescription;
	}

}
