package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Formatter;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.util.converter.LocalTimeStringConverter;
import AlertMessage.message;
import DBConnection.Connectio;

public class TimeCardController {
	
	 @FXML
	    private JFXButton in;

	    @FXML
	    private JFXButton out;
	    
	    @FXML
	    private JFXButton hours;

	    @FXML
	    private JFXButton brk;
	    
	    private PreparedStatement pst;
	   
	   
	    Connection con;
	    Connectio conClass = new Connectio();
	    
	   
	    LocalTime localtime = LocalTime.now();
	    String checkout=localtime.format(DateTimeFormatter.ofPattern("hh:mm"));
	    String checkin= localtime.format(DateTimeFormatter.ofPattern("hh:mm"));
	    String Break= localtime.format(DateTimeFormatter.ofPattern("hh:mm"));
	  
	    
	    message msg = new message();
	    @FXML
	    void CheckOut(ActionEvent event) throws ClassNotFoundException, SQLException {
	    	
	    	con=conClass.getConnection();
	    	
        msg.setMessage("You are checked out on: "+checkout);
        
	    }

	    @FXML
	    void checkin(ActionEvent event) throws ClassNotFoundException, SQLException {    	
            
	    	con=conClass.getConnection();	    	
	    	System.out.println("Connection established");
        msg.setMessage("You are checked out on: "+checkin);
	    }

	    @FXML
	    void StartBreak(ActionEvent event) throws ClassNotFoundException, SQLException {
	    	con=conClass.getConnection();	    	
	    	System.out.println("Connection established");
           msg.setMessage("Your break is started on: "+checkin);
	    }
	    @FXML
	    void totalhours(ActionEvent event) throws ClassNotFoundException, SQLException {
	    	con=conClass.getConnection();	    	
	    	System.out.println("Connection established");
	    	
        msg.setMessage("Total hours you work on: ");
	    }

}
