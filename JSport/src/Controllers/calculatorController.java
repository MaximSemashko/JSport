package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class calculatorController {

    @FXML
    private MenuButton MenuButton;

    @FXML
    private MenuItem AccountButton;

    @FXML
    private MenuItem ChangeUserButton1;

    @FXML
    private MenuItem ChangeUserButton;

    @FXML
    private MenuItem QuitButton;

    @FXML
    private MenuItem JSportButton;

    @FXML
    private TextField Height;

    @FXML
    private TextField Weight;

    @FXML
    private Button LoadButton;

    @FXML
    private Label looseWeight;

    @FXML
    private Label GainWeight;

    @FXML
    private Label bmi;

    @FXML
    private Label normalWeight;

    @FXML
    private ComboBox<String> productsBox;

    @FXML
    private Label kCalLabel;

    @FXML
    private Label kJLabel;

    @FXML
    private Button calculateButton;

    @FXML
    private TextField grams;

    public void initialize() {

        //-------------------------------------------------------

        //open window with main menu

        JSportButton.setOnAction(event -> {
            openNewScene("/Front/JSportMenu.fxml");
        });

        //Open window with users information

        AccountButton.setOnAction(event -> {
            openNewScene("/Front/UsersInformation.fxml");
        });

        //Open 1st window wich allows to change user

        ChangeUserButton.setOnAction(event -> {
            openNewScene("/Front/sample.fxml");
        });

        //quit from programm

        QuitButton.setOnAction(event -> {
            System.exit(0);
        });

        //-------------------------------------------------------

        //Calculate callories for day:

        LoadButton.setOnAction(event -> {

            //initial info
            float userHeigh, userWeight;
            userHeigh = Float.parseFloat(Height.getText());
            userWeight = Float.parseFloat(Weight.getText());

            //Calculations:

            looseWeight.setText(String.valueOf(10 * userWeight + 6.25 * userHeigh - 200));
            GainWeight.setText(String.valueOf(10 * userWeight + 6.25 * userHeigh + 200));
            bmi.setText(String.valueOf(userWeight / ((userHeigh / 100) * (userHeigh / 100))));
            normalWeight.setText(String.valueOf(userHeigh - 110));
        });

        //Calculator for products
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Chicken",
                        "Pork",
                        "Buckwheat",
                        "Potato",
                        "Macaroni"
                );
        productsBox.setItems(options);
        calculateButton.setOnAction(event -> {
            float productWeight;
            productWeight = Float.parseFloat(grams.getText());

            if (productsBox.getValue() == "Chicken") {
                kCalLabel.setText(String.valueOf(productWeight / 100 * 200));
                kJLabel.setText(String.valueOf(productWeight / 100 * 200 * 4.184));
            }

            if (productsBox.getValue() == "Pork") {
                kCalLabel.setText(String.valueOf(productWeight / 100 * 242));
                kJLabel.setText(String.valueOf(productWeight / 100 * 242 * 4.184));
            }

            if (productsBox.getValue() == "Buckwheat") {
                kCalLabel.setText(String.valueOf(productWeight / 100 * 132));
                kJLabel.setText(String.valueOf(productWeight / 100 * 132 * 4.184));
            }

            if (productsBox.getValue() == "Potato") {
                kCalLabel.setText(String.valueOf(productWeight / 100 * 77));
                kJLabel.setText(String.valueOf(productWeight / 100 * 77 * 4.184));
            }

            if (productsBox.getValue() == "Macaroni") {
                kCalLabel.setText(String.valueOf(productWeight / 100 * 330));
                kJLabel.setText(String.valueOf(productWeight / 100 * 330 * 4.184));
            }
        });
    }
    //Method to return to main page

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
