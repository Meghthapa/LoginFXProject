package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import DBConnection.Connectio;
import AlertMessage.message;
public class loginController {

	  @FXML
	    private AnchorPane anPane;

	    @FXML
		private JFXTextField user;

	    @FXML
	    private Label loginlabel;

	    @FXML
	    private JFXPasswordField pass;

	    @FXML
	    private JFXButton Forget;

	    @FXML
	    private JFXButton login;

	    @FXML
	    private JFXButton register;
	    
	    private PreparedStatement pst;
	    Connection con;
	    Connectio conClass=new Connectio();
	    message msg=new message();
	    
	    @FXML
	    void forgetPassword(ActionEvent event) throws IOException {
          Forget.getScene().getWindow().hide();
          Stage login = new Stage();
          Parent root= FXMLLoader.load(getClass().getResource("/FXML_Files/forgetpassword.fxml"));
          Scene scene = new Scene(root);
          login.setScene(scene);
          login.show();
	    }


	   

	    @FXML
	    void createlogin(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
           con=conClass.getConnection();
           String str ="Select * from myfirstproject.signup where fullName=? and Password=?";
           pst = con.prepareStatement(str);
           pst.setString(1,user.getText());
           pst.setString(2, pass.getText());
           ResultSet rs= pst.executeQuery();
           int count=0;
           while(rs.next()) {
        	   count=count+1;
           }
           if(count ==1) {
        	   login.getScene().getWindow().hide();
        	   Stage s = new Stage();
        	   Parent root= FXMLLoader.load(getClass().getResource("/FXML_Files/HomePage.fxml"));
        	   s.setScene(new Scene(root));
        	   s.show();
        	   msg.setMessage("Login is sucessful");
           }else {
        	   msg.setMessage("Invalid login credentials");
           }
           
	    }
	    @FXML
	    void createRegister(ActionEvent event) throws IOException {
          register.getScene().getWindow().hide();
          Stage signup=new Stage();
          Parent root =FXMLLoader.load(getClass().getResource("/FXML_Files/SignUp.fxml"));
          Scene scene = new Scene(root);
          signup.setScene(scene);
          signup.show();
          
	    }




		

}
