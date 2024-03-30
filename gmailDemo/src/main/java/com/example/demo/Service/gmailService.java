package com.example.demo.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.starterClass;
import com.example.demo.gmailController.ResponseDTO;

public interface gmailService {

	public ResponseEntity<?> SaveGmail(starterClass startclass);

	public String updategmail(starterClass startclass);

	public String deleteGmail(int gmailId);

	public starterClass getGmail(int gmailId);

	public ResponseDTO getAllGmail();
	
	public ResponseDTO getDeleteAllGmail();
	
	//public String Read(int gmailId,boolean b);
	
	//public String UnRead(int gmailId, boolean b);

	public ResponseDTO Read1(int gmailId, boolean b);

	ResponseDTO UnRead1(int gmailId, boolean b);
}
