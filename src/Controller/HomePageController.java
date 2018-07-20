package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import DBConnection.Connectio;

public class HomePageController implements Initializable {
	
	@FXML
    private JFXButton show;
	
	@FXML
    private JFXButton time;

	 @FXML
	 private TableColumn<Student, String> fullname;

	 @FXML
	 private TableColumn<Student, String> password;

	 @FXML
	 private TableColumn<Student, String> email;

    @FXML
    private TableView<Student> table;
    
    Connection con;
    PreparedStatement pst;
    Connectio cont = new Connectio();
    
    @FXML
    void Actiontime(ActionEvent event) throws IOException {
     time.getScene().getWindow().hide();
     Stage s= new Stage();
     Parent root = FXMLLoader.load(getClass().getResource("/FXML_Files/TimeEntry.fxml"));
     Scene scene = new Scene(root);
     s.setScene(scene);
     s.show();
    }

    @FXML
    void showData(ActionEvent event) throws ClassNotFoundException, SQLException {
       con=cont.getConnection();
       
       ObservableList<Student> data = FXCollections.observableArrayList();
       table.setItems(data);
       String str = "SELECT * FROM myfirstproject.signup";
       pst = con.prepareStatement(str);
       ResultSet rs = pst.executeQuery();
       
       while(rs.next()) {
    	   Student s= new Student(rs.getString("fullName"),rs.getString("Password"),rs.getString("email"));
    	   data.add(s);
    	   
       }
       
       
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		fullname.setCellValueFactory(new PropertyValueFactory<Student, String>("fullName"));
		password.setCellValueFactory(new PropertyValueFactory<Student, String>("password"));
		email.setCellValueFactory(new PropertyValueFactory<Student, String>("email"));
		
	}

}
