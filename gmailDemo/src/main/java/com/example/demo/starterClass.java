package com.example.demo;

import java.security.Timestamp;

//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Gmail_Table")
public class starterClass {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int gmailId;
	private String gmailTitle;
	private String gmailDescription;
	private boolean Boolean = false;

	//@CreationTimestamp
	//private Timestamp createdAt;

	//@UpdateTimestamp
	//private Timestamp updatedAt;

	public starterClass() {

	}

	public starterClass(int gmailId, String gmailTitle, String gmailDescription, boolean Boolean,Timestamp createdAt,Timestamp updatedAt) {
		this.gmailId = gmailId;
		this.gmailTitle = gmailTitle;
		this.gmailDescription = gmailDescription;
		this.Boolean = Boolean;
		//this.createdAt=createdAt;
		//this.updatedAt=updatedAt;
	}

	public int getGmailid() {
		return gmailId;
	}

	public void setGmailid(int gmailid) {
		this.gmailId = gmailid;
	}

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

	public boolean isBoolean() {
		return Boolean;
	}

	public void setBoolean(boolean b) {
		Boolean = b;
	}

	public void setRead(boolean b) {
		this.Boolean = b;
	}

	public void setunread(boolean b) {
		this.Boolean = b;
	}

	/* 
	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}  */

}
