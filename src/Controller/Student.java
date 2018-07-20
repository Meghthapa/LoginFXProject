package Controller;

import javafx.beans.property.SimpleStringProperty;

public class Student {

	private final SimpleStringProperty fullName;
	private final SimpleStringProperty Password;
	private final SimpleStringProperty email;
	
	 Student(String fName,String pass,String em) {
		this.fullName=new SimpleStringProperty(fName);
		this.Password= new SimpleStringProperty(pass);
		this.email= new SimpleStringProperty(em);
	}
	
	public String getFullName() {
		return fullName.get();
		
	}
	public void setFullName(String fName) {
		fullName.set(fName);
	}
	public String getPassword() {
		return Password.get();
		
	}
	public void setPassword(String pass) {
		fullName.set(pass);
	}
	public String getEmail() {
		return email.get();
		
	}
	public void setEmail(String em) {
		fullName.set(em);
	}
}
