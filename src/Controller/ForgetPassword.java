package Controller;

import javafx.event.ActionEvent;
import DBConnection.Connectio;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import AlertMessage.message;



public class ForgetPassword {
	private PreparedStatement ps;
	

	   @FXML
	    private JFXTextField User;

	    @FXML
	    private JFXPasswordField password;
	    
	    @FXML
	    private JFXButton Backlogin;

	    @FXML
	    private JFXButton submit;
	    
	    Connection con;
	    Connectio c = new Connectio();
	    message msg=new message();
	    
	    

	    @FXML
	    void SubmitAction(ActionEvent event) throws ClassNotFoundException, SQLException {
         con =c.getConnection();
         System.out.println("DB is connected");
         String update="update myfirstproject.signup set password =? where fullName=?";
         ps=con.prepareStatement(update);
         ps.setString(2, User.getText());
         ps.setString(1, password.getText());
         Integer rs=ps.executeUpdate();
         int count = 0;
         while(rs.equals(User.getText())) {
        	 count =count+1;
         }
         msg.setMessage("Your password has  been updated");
         
         
	    }
	    @FXML
	    void BackToLogin(ActionEvent event) throws IOException {
          Backlogin.getScene().getWindow().hide();
          Stage login = new Stage();
          Parent root = FXMLLoader.load(getClass().getResource("/FXML_Files/login.fxml"));
          Scene s = new Scene(root);
          login.setScene(s);
          login.show();
	    }

	
}
