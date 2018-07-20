package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import DBConnection.Connectio;
import AlertMessage.message;

public class SignUpController implements Initializable {
   
	  @FXML
	    private AnchorPane Password;

	    @FXML
	    private JFXTextField fullname;

	    @FXML
	    private JFXPasswordField password;

	    @FXML
	    private JFXTextField email;

	    @FXML
	    private JFXButton signup;

	    @FXML
	    private JFXButton signuplogin;
	    
	    private PreparedStatement ps;
	    
	    @FXML
	    private JFXCheckBox checkbox;
	    
	    Connection conn;
	    Connectio conobj = new Connectio();
	    message msg=new message();

	  

	    @FXML
	    void login(ActionEvent event) throws IOException {
          signuplogin.getScene().getWindow().hide();
          Stage login = new Stage();
          Parent root = FXMLLoader.load(getClass().getResource("/FXML_Files/login.fxml"));
          Scene scene = new Scene(root);
          login.setScene(scene);
          login.show();
	    }

	    @FXML
	    void signupAction(ActionEvent event) throws ClassNotFoundException, SQLException {
	    	
	    	if(checkbox.isSelected()) {
	    		conn=conobj.getConnection();
		    	System.out.println("DB is connected ");
		    	String insert="Insert into myfirstproject.signup(fullName,Password,email)"+ "values(?,?,?)";
		    	ps=conn.prepareStatement(insert);
		    	ps.setString(1, fullname.getText());
		    	ps.setString(2, password.getText());
		    	ps.setString(3, email.getText());
		    	ps.executeUpdate();
		    	msg.setMessage("You are sucessfully sign up");
	    	}
	    	else {
	    		msg.setMessage("Please agree terms and condition");
	    	}
	    	

	    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		fullname.setStyle("-fx-text-inner-color:#afbccd");
		email.setStyle("-fx-text-inner-color:#afbccd");
		password.setStyle("-fx-text-inner-color:#afbccd");
	}

}
