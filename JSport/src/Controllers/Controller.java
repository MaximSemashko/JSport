package Controllers;

import Database.ConnectionClass;
import Database.Const;
import animations.Shake;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.User;

import javax.xml.soap.Node;
import java.io.IOException;
import java.sql.*;

public class Controller {

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button signIn;

    @FXML
    private Button signUp;



    /*Method to open new Scenes
    variable "window" - is a path to Scene*/

    public void openNewScene(String window) {
        signIn.getScene().getWindow().hide();
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
        stage.showAndWait();

    }
    public void initialize() {

        //Check for input data

        signIn.setOnAction(event -> {
            String loginText = login_field.getText().trim();
            String passwordText = password_field.getText().trim();
            if (!loginText.equals("") && !passwordText.equals("")) {
                try {
                    loginUser(loginText, passwordText);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                Shake userLoginAnim = new Shake(signIn);
                userLoginAnim.playAnim();
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setHeaderText("Login and password is empty");
                alert.setContentText("Careful with the next step!");
                alert.showAndWait();
            }

        });

        //get window RegMenu

        signUp.setOnAction(event -> {
            openNewScene("/Front/RegMenu.fxml");
        });
    }

    //Method to sign in

    private void loginUser(String loginText, String passwordText) throws SQLException {
        ConnectionClass dbHandler = new ConnectionClass();
        User user = new User();
        user.setUserName(loginText);
        user.setPassword(passwordText);
        ResultSet result = dbHandler.getUser(user);
        int count = 0;
        while (result.next()) {
            count++;
        }
        if (count >= 1) {
            openNewScene("/Front/JSportMenu.fxml");

        } else {
            Shake userLoginAnim = new Shake(signIn);
            userLoginAnim.playAnim();
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Incorrect information");
            alert.setContentText("Careful with the next step!");
            alert.showAndWait();

        }
    }
}