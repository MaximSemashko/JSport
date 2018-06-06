package Controllers;

import Database.ConnectionClass;
import Database.Const;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JSportMenuController {

    @FXML
    private Button HomeExerciseButton;

    @FXML
    private Button RunExerciseButton;

    @FXML
    private Button WorkoutExerciseButton;

    @FXML
    private Button GymExerciseButton;

    @FXML
    private MenuButton MenuButton;

    @FXML
    private MenuItem AccountButton;

    @FXML
    private MenuItem CalculatorButton;

    @FXML
    private MenuItem ChangeUserButton;

    @FXML
    private MenuItem QuitButton;

    public void initialize() throws SQLException {

        //Home exercises window

        HomeExerciseButton.setOnAction(event -> {
            openNewScene("/Front/HomeExercises.fxml");
        });

        //Run exercises window

        RunExerciseButton.setOnAction(event -> {
            openNewScene("/Front/RunExercises.fxml");
        });

        //Gym exercises window

        GymExerciseButton.setOnAction(event -> {
            openNewScene("/Front/GymExercises.fxml");
        });

        //Workout exercises window

        WorkoutExerciseButton.setOnAction(event -> {
            openNewScene("/Front/WorkoutExercises.fxml");
        });

        //Open window with users information

        AccountButton.setOnAction(event -> {
            openNewScene("/Front/UsersInformation.fxml");
        });

        //Open 1st window wich allows to change user

        ChangeUserButton.setOnAction(event -> {
            openNewScene("/Front/sample.fxml");
        });

        //Open calculator

        CalculatorButton.setOnAction(event -> {
            openNewScene("/Front/Calculator.fxml");
        });

        //quit from programm

        QuitButton.setOnAction(event -> {
            System.exit(0);
        });


     }

    //Method to return to main page

    public void openNewScene(String window) {
        HomeExerciseButton.getScene().getWindow().hide();
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