package Controllers;

import Database.ConnectionClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import Exercises.HomeExercises;

import java.io.IOException;
import java.sql.*;

public class HomeExercisesController {

    @FXML
    private TableView<HomeExercises> HomeTrain;

    @FXML
    private TableColumn<HomeExercises,Integer> dayColumn;

    @FXML
    private TableColumn<HomeExercises,Integer> setsColumn;

    @FXML
    private TableColumn<HomeExercises,Integer> squatsColumn;

    @FXML
    private TableColumn<HomeExercises,Integer> pushUpsColumn;

    @FXML
    private TableColumn<HomeExercises,Integer> pressColumn;

    @FXML
    private TableColumn<HomeExercises,Integer> rearPushUpsColumn;

    @FXML
    private TableColumn<HomeExercises,Integer> impactsColumn;

    @FXML
    private TableColumn<HomeExercises,Float> plankColumn;
    @FXML
    private Button LoadButton;

    @FXML
    private Button AddButton;

    @FXML
    private Button DeleteButton;

    @FXML
    private TextField squatsAdd;

    @FXML
    private TextField pushUpsAdd;

    @FXML
    private TextField pressAdd;

    @FXML
    private TextField rPushUpsAdd;

    @FXML
    private TextField impactsAdd;

    @FXML
    private TextField plankAdd;

    @FXML
    private Button toMainPage;

    @FXML
    private TextField dayAdd;

    @FXML
    private TextField setsAdd;

    //List of data that we will add to db

    final ObservableList<HomeExercises> data=FXCollections.observableArrayList();

    public void initialize(){
        dayColumn.setCellValueFactory(new PropertyValueFactory<HomeExercises,Integer>("days"));
        setsColumn.setCellValueFactory(new PropertyValueFactory<HomeExercises,Integer>("sets"));
        squatsColumn.setCellValueFactory(new PropertyValueFactory<HomeExercises,Integer>("squatsNumber"));
        pushUpsColumn.setCellValueFactory(new PropertyValueFactory<HomeExercises,Integer>("pushUpsNumber"));
        pressColumn.setCellValueFactory(new PropertyValueFactory<HomeExercises,Integer>("pressNumber"));
        rearPushUpsColumn.setCellValueFactory(new PropertyValueFactory<HomeExercises,Integer>("rearPushUpsNumber"));
        impactsColumn.setCellValueFactory(new PropertyValueFactory<HomeExercises,Integer>("impactsNumber"));
        plankColumn.setCellValueFactory(new PropertyValueFactory<HomeExercises,Float>("plankDuration"));


        //use method getHomeExercises()

        HomeTrain.setItems(getHomeExercises());

        //To main page button

        toMainPage.setOnAction(event -> {
            openNewScene("/Front/JSportMenu.fxml");
        });

        AddButton.setOnAction(event -> {
            getNewHomeTrain();
            addButtonClick();

        });

        //Use method to delete from current table

        DeleteButton.setOnAction(event -> {
            deleteButtonClick();
            //Here will be button that delete from db
        });

        //Use method to load info from db

        LoadButton.setOnAction(event -> {
            LoadInformationFromHomeExercises();
        });
    }

    //Method loads information from homeexercises table(db)

    private void LoadInformationFromHomeExercises(){ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "SELECT  * FROM homeexercises;";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                data.add(new HomeExercises(
                        resultSet.getInt("day"),
                        resultSet.getInt("sets"),
                        resultSet.getInt("squats"),
                        resultSet.getInt("pushUps"),
                        resultSet.getInt("press"),
                        resultSet.getInt("rearPushUps"),
                        resultSet.getInt("impacts"),
                        resultSet.getFloat("plank")
                ));
                HomeTrain.setItems(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //Method returns ObservableList of HomeExercise objects

    private ObservableList<HomeExercises> getHomeExercises() {
        ObservableList<HomeExercises> homeExercises= FXCollections.observableArrayList();
        homeExercises.add(new HomeExercises(1,5,30,20,20,20,20,1));
        return homeExercises;
    }

    //Open main page

    public void openNewScene(String window) {
        toMainPage.getScene().getWindow().hide();
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

    //Add to table

    public void addButtonClick(){
        HomeExercises homeEx =new HomeExercises();
        homeEx.setDays(Integer.parseInt(dayAdd.getText()));
        homeEx.setSets(Integer.parseInt(setsAdd.getText()));
        homeEx.setSquatsNumber(Integer.parseInt(squatsAdd.getText()));
        homeEx.setPushUpsNumber(Integer.parseInt(pushUpsAdd.getText()));
        homeEx.setPressNumber(Integer.parseInt(pressAdd.getText()));
        homeEx.setRearPushUpsNumber(Integer.parseInt(rPushUpsAdd.getText()));
        homeEx.setImpactsNumber(Integer.parseInt(impactsAdd.getText()));
        homeEx.setPlankDuration(Float.parseFloat(plankAdd.getText()));
        HomeTrain.getItems().add(homeEx);
        dayAdd.clear();
        setsAdd.clear();
        squatsAdd.clear();
        pushUpsAdd.clear();
        pressAdd.clear();
        rPushUpsAdd.clear();
        impactsAdd.clear();
        plankAdd.clear();
    }

    //Delete from table

    public void deleteButtonClick(){
        ObservableList<HomeExercises> homeExercisesSelected,allHomeExercises;
        allHomeExercises=HomeTrain.getItems();
        homeExercisesSelected=HomeTrain.getSelectionModel().getSelectedItems();
        homeExercisesSelected.forEach(allHomeExercises::remove);
    }

    //Method adds data to db

    private boolean getNewHomeTrain(){
        ConnectionClass connectionClass = new ConnectionClass();
        Integer days= Integer.valueOf(dayAdd.getText());
        Integer  sets= Integer.valueOf(setsAdd.getText());
        Integer  squatsNumber= Integer.valueOf(squatsAdd.getText());
        Integer  pushUpsNumber= Integer.valueOf(pushUpsAdd.getText());
        Integer  pressNumber= Integer.valueOf(pressAdd.getText());
        Integer  rearPushUpsNumber= Integer.valueOf(rPushUpsAdd.getText());
        Integer impactsNumber= Integer.valueOf(impactsAdd.getText());
        Float plankDuration= Float.valueOf(Integer.valueOf(plankAdd.getText()));
        HomeExercises homeExercises=new HomeExercises(days,  sets,  squatsNumber, pushUpsNumber,  pressNumber, rearPushUpsNumber,  impactsNumber,  plankDuration);
        try {
            connectionClass.AddHomeTrain(homeExercises);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
