package Controllers;
import Database.ConnectionClass;
import animations.Shake;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.User;

import java.io.IOException;
import java.sql.SQLException;

public class RegMenuController {
    @FXML
    private TextField RegName;

    @FXML
    private TextField RegLastname;

    @FXML
    private DatePicker RegBirthday;

    @FXML
    private TextField RegEmail;

    @FXML
    private TextField RegLogin;

    @FXML
    private PasswordField RegPassword;

    @FXML
    private Button RegButton;



    //Method to return to main page

    public void openNewScene(String window) {
       RegButton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

    }

    //Call the method signUpNewUser and check it(true or false)

    public void RegButton(ActionEvent actionEvent) throws SQLException {
        if(RegName.equals("")||RegLastname.equals("")||RegEmail.equals("")||
                RegBirthday.equals("")||RegLogin.equals("")||RegPassword.equals("")) {
//       if( signUpNewUser()==true ){
//           System.out.println("User was registred!");
//           openNewScene("/Front/sample.fxml");
//       };
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText("Ooops, there was an error!");
            alert.showAndWait();
        }
        else{
            signUpNewUser();
            System.out.println("User was registred!");
         openNewScene("/Front/sample.fxml");

        }
      }


        //Method takes data from TextFields and realize method signUpUser

        private boolean signUpNewUser(){
            ConnectionClass connectionClass = new ConnectionClass();
            String firstName=RegName.getText();
            String lastName=RegLastname.getText();
            String email=RegEmail.getText();
            String birthday= String.valueOf(RegBirthday.getValue());
            String userName=RegLogin.getText();
            String password=RegPassword.getText();

            User user=new User(firstName,lastName,email,birthday,userName,password);
            try {
                if(firstName.isEmpty()||lastName.isEmpty()||email.isEmpty()||birthday.isEmpty()||userName.isEmpty()||password.isEmpty()){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Dialog");
                    alert.setHeaderText("Look, an Error Dialog");
                    alert.setContentText("Ooops, there was an error!");
                    alert.showAndWait();
                }
                else
                connectionClass.signUpUser(user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return true;
        }
    }











