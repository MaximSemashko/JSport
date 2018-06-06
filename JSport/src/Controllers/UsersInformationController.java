package Controllers;

import Database.ConnectionClass;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsersInformationController {

    @FXML
    private Label nameLabel;

    @FXML
    private Label SurnameLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label birthdayLabel;

    @FXML
    private Label loginLabel;

    @FXML
    private Label passwordLabel;

    @FXML
    private MenuButton MenuButton;

    @FXML
    private MenuItem JSportButton;

    @FXML
    private MenuItem ChangeUserButton;

    @FXML
    private MenuItem CalculatorButton;

    @FXML
    private MenuItem QuitButton;

    public void initialize() throws SQLException {

        //Take info from db

        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM USERS";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            this.nameLabel.setText(resultSet.getString(2));
            this.SurnameLabel.setText(resultSet.getString(3));
            this.emailLabel.setText(resultSet.getString(4));
            this.birthdayLabel.setText(resultSet.getString(5));
            this.loginLabel.setText(resultSet.getString(6));
            this.passwordLabel.setText(resultSet.getString(7));
        }
        //Open window with users information

        JSportButton.setOnAction(event -> {
            openNewScene("/Front/JSportMenu.fxml");
        });

        //Open calculator

        CalculatorButton.setOnAction(event -> {
            openNewScene("/Front/Calculator.fxml");
        });

        //Open 1st window wich allows to change user

        ChangeUserButton.setOnAction(event -> {
            openNewScene("/Front/sample.fxml");
        });

        //quit from programm

        QuitButton.setOnAction(event -> {
            System.exit(0);
        });
        //Method to return to main page
    }

    public void openNewScene(String window) {
        MenuButton.getScene().getWindow().hide();
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
}
