package com.example.demo.gmailController;

public class ResponseDTO {
private Boolean is_sucess;
public Object data;
public String message;

public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public Boolean getIs_sucess() {
	return is_sucess;
}
public void setIs_sucess(Boolean is_sucess) {
	this.is_sucess = is_sucess;
}
public Object getData() {
	return data;
}
public void setData(Object data) {
	this.data = data;
}
public ResponseDTO(Boolean is_sucess, Object data,String message) {
	super();
	this.is_sucess = is_sucess;
	this.data = data;
	this.message=message;
}



}