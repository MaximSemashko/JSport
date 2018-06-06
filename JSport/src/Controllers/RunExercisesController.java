package Controllers;

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
import Exercises.RunExercises;

import java.io.IOException;

public class RunExercisesController {

    @FXML
    private TableView<RunExercises> RunTrain;

    @FXML
    private TableColumn<RunExercises, Integer> dayColumn;

    @FXML
    private TableColumn<RunExercises, Integer> runColumn;

    @FXML
    private TableColumn<RunExercises, Integer> squatsColumn;

    @FXML
    private TableColumn<RunExercises, Integer> runWithAccelerationColumn;

    @FXML
    private TableColumn<RunExercises, Integer> impactsColumn;

    @FXML
    private Button LoadButton;

    @FXML
    private Button AddButton;

    @FXML
    private Button DeleteButton;

    @FXML
    private TextField squatsAdd;

    @FXML
    private TextField runWithAccelerationAdd;

    @FXML
    private TextField impactsAdd;

    @FXML
    private Button toMainPage;

    @FXML
    private TextField dayAdd;

    @FXML
    private TextField runAdd;

    //List of data that we will add to db

    final ObservableList<RunExercises> data= FXCollections.observableArrayList();

    public void initialize(){
        dayColumn.setCellValueFactory(new PropertyValueFactory<RunExercises,Integer>("days"));
        squatsColumn.setCellValueFactory(new PropertyValueFactory<RunExercises,Integer>("runing"));
        runColumn.setCellValueFactory(new PropertyValueFactory<RunExercises,Integer>("squats"));
        impactsColumn.setCellValueFactory(new PropertyValueFactory<RunExercises,Integer>("runningWithAcceleration"));
        runWithAccelerationColumn.setCellValueFactory(new PropertyValueFactory<RunExercises,Integer>("impacts"));


        //use method getRunExercises()

        RunTrain.setItems(getRunExercises());

        //To main page button

        toMainPage.setOnAction(event -> {
            openNewScene("/Front/JSportMenu.fxml");
        });

        AddButton.setOnAction(event -> {
        //    getNewHomeTrain();
            addButtonClick();

        });

        //Use method to delete from current table

        DeleteButton.setOnAction(event -> {
            deleteButtonClick();
            //Here will be button that delete from db
        });

        //Use method to load info from db

        LoadButton.setOnAction(event -> {
//            LoadInformationFromHomeExercises();
        });
    }

    //Method loads information from homeexercises table(db)

//    private void LoadInformationFromHomeExercises(){
//        ConnectionClass connectionClass = new ConnectionClass();
//        Connection connection = connectionClass.getConnection();
//        Statement statement = null;
//        try {
//            statement = connection.createStatement();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        String sql = "SELECT  * FROM homeexercises;";
//        try {
//            ResultSet resultSet = statement.executeQuery(sql);
//            while(resultSet.next()){
//                data.add(new HomeExercises(
//                        resultSet.getInt("day"),
//                        resultSet.getInt("sets"),
//                        resultSet.getInt("squats"),
//                        resultSet.getInt("pushUps"),
//                        resultSet.getInt("press"),
//                        resultSet.getInt("rearPushUps"),
//                        resultSet.getInt("impacts"),
//                        resultSet.getFloat("plank")
//                ));
//                HomeTrain.setItems(data);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }


    //Method returns ObservableList of HomeExercise objects

    private ObservableList<RunExercises> getRunExercises() {
        ObservableList<RunExercises> runExercises= FXCollections.observableArrayList();
       runExercises.add(new RunExercises(1,2,3,4,5));
        return runExercises;
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

    public void addButtonClick() {
        RunExercises runEx = new RunExercises();
        runEx.setDays(Integer.parseInt(dayAdd.getText()));
        runEx.setRuning(Integer.parseInt(runAdd.getText()));
        runEx.setSquats(Integer.parseInt(squatsAdd.getText()));
        runEx.setRunningWithAcceleration(Integer.parseInt(runWithAccelerationAdd.getText()));
        runEx.setImpacts(Integer.parseInt(impactsAdd.getText()));

        RunTrain.getItems().add(runEx);
        dayAdd.clear();
        runAdd.clear();
        squatsAdd.clear();
        runWithAccelerationAdd.clear();
        impactsAdd.clear();
    }

    //Delete from table

    public void deleteButtonClick(){
        ObservableList<RunExercises> runExercisesSelected,allRunExercises;
        allRunExercises=RunTrain.getItems();
        runExercisesSelected=RunTrain.getSelectionModel().getSelectedItems();
        runExercisesSelected.forEach(allRunExercises::remove);
    }

    //Method adds data to db
//
//    private boolean getNewHomeTrain(){
//        ConnectionClass connectionClass = new ConnectionClass();
//        Integer days= Integer.valueOf(dayAdd.getText());
//        Integer  sets= Integer.valueOf(setsAdd.getText());
//        Integer  squatsNumber= Integer.valueOf(squatsAdd.getText());
//        Integer  pushUpsNumber= Integer.valueOf(pushUpsAdd.getText());
//        Integer  pressNumber= Integer.valueOf(pressAdd.getText());
//        Integer  rearPushUpsNumber= Integer.valueOf(rPushUpsAdd.getText());
//        Integer impactsNumber= Integer.valueOf(impactsAdd.getText());
//        Float plankDuration= Float.valueOf(Integer.valueOf(plankAdd.getText()));
//        HomeExercises homeExercises=new HomeExercises(days,  sets,  squatsNumber, pushUpsNumber,  pressNumber, rearPushUpsNumber,  impactsNumber,  plankDuration);
//        try {
//            connectionClass.AddHomeTrain(homeExercises);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return true;
//    }
}

