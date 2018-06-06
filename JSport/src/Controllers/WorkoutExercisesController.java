package Controllers;

import Database.ConnectionClass;
import Exercises.GymExercises;
import Exercises.WorkoutExercises;
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

import java.io.IOException;

public class WorkoutExercisesController {

    @FXML
    private TableView<WorkoutExercises> WorkoutTrain;

    @FXML
    private TableColumn<WorkoutExercises, Integer> dayColumn;

    @FXML
    private TableColumn<WorkoutExercises, Integer> setsColumn;

    @FXML
    private TableColumn<WorkoutExercises, Integer> jumpSquatsColumn;

    @FXML
    private TableColumn<WorkoutExercises, Integer> dipsColumn;

    @FXML
    private TableColumn<WorkoutExercises,Integer> pullUpsColumn;

    @FXML
    private TableColumn<WorkoutExercises,Integer> australianPullUpsColumn;

    @FXML
    private Button LoadButton;

    @FXML
    private Button AddButton;

    @FXML
    private Button DeleteButton;

    @FXML
    private TextField jumpingSquatsAdd;

    @FXML
    private TextField dipsAdd;

    @FXML
    private TextField pullUpsAdd;

    @FXML
    private TextField australianPullUpsAdd;

    @FXML
    private Button toMainPage;

    @FXML
    private TextField dayAdd;

    @FXML
    private TextField setsAdd;


//List of data that we will add to db

    final ObservableList<WorkoutExercises> data = FXCollections.observableArrayList();

    public void initialize() {
        dayColumn.setCellValueFactory(new PropertyValueFactory<WorkoutExercises, Integer>("days"));
        setsColumn.setCellValueFactory(new PropertyValueFactory<WorkoutExercises, Integer>("sets"));
        jumpSquatsColumn.setCellValueFactory(new PropertyValueFactory<WorkoutExercises, Integer>("squatsWithJump"));
      dipsColumn.setCellValueFactory(new PropertyValueFactory<WorkoutExercises, Integer>("dips"));
        pullUpsColumn.setCellValueFactory(new PropertyValueFactory<WorkoutExercises, Integer>("pullUps"));
        australianPullUpsColumn.setCellValueFactory(new PropertyValueFactory<WorkoutExercises, Integer>("australianPullUps"));


        //use method getHomeExercises()

        WorkoutTrain.setItems(getWorkoutExercises());

        //To main page button

        toMainPage.setOnAction(event -> {
            openNewScene("/Front/JSportMenu.fxml");
        });

        AddButton.setOnAction(event -> {
            // getNewHomeTrain();
            addButtonClick();

        });

        //Use method to delete from current table

        DeleteButton.setOnAction(event -> {
            deleteButtonClick();
            //Here will be button that delete from db
        });

        //Use method to load info from db

        LoadButton.setOnAction(event -> {
            //  LoadInformationFromHomeExercises();
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


    //Method returns ObservableList of GymExercise objects

    private ObservableList<WorkoutExercises> getWorkoutExercises() {
        ObservableList<WorkoutExercises> workoutExercises = FXCollections.observableArrayList();
        workoutExercises.add(new WorkoutExercises(1, 2, 3, 4, 5, 6));
        return workoutExercises;
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
        WorkoutExercises workoutEx = new WorkoutExercises();
        workoutEx.setDays(Integer.parseInt(dayAdd.getText()));
        workoutEx.setSets(Integer.parseInt(setsAdd.getText()));
        workoutEx.setSquatsWithJump(Integer.parseInt(jumpingSquatsAdd.getText()));
        workoutEx.setDips(Integer.parseInt(dipsAdd.getText()));
        workoutEx.setPullUps(Integer.parseInt(pullUpsAdd.getText()));
        workoutEx.setAustralianPullUps(Integer.parseInt(australianPullUpsAdd.getText()));
        WorkoutTrain.getItems().add(workoutEx);
        dayAdd.clear();
        setsAdd.clear();
        dipsAdd.clear();
        jumpingSquatsAdd.clear();
        pullUpsAdd.clear();
        australianPullUpsAdd.clear();

    }

    //Delete from table

    public void deleteButtonClick() {
        ObservableList<WorkoutExercises> workoutExercisesSelected, allWorkoutExercises;
        allWorkoutExercises = WorkoutTrain.getItems();
        workoutExercisesSelected = WorkoutTrain.getSelectionModel().getSelectedItems();
        workoutExercisesSelected.forEach(allWorkoutExercises::remove);
    }

    //Method adds data to db

//    private boolean getNewWorkoutTrain(){
//        ConnectionClass connectionClass = new ConnectionClass();
//        Integer days= Integer.valueOf(dayAdd.getText());
//        Integer  sets= Integer.valueOf(setsAdd.getText());
//        Integer  squatsWithJump= Integer.valueOf(jumpingSquatsAdd.getText());
//        Integer  pushUpsNumber= Integer.valueOf(pushUpsAdd.getText());
//        Integer  pressNumber= Integer.valueOf(pressAdd.getText());
//        Integer  rearPushUpsNumber= Integer.valueOf(rPushUpsAdd.getText());
//        Integer impactsNumber= Integer.valueOf(impactsAdd.getText());
//        Float plankDuration= Float.valueOf(Integer.valueOf(plankAdd.getText()));
//        HomeExercises homeExercises=new HomeExercises(days,  sets,  squatsWithJump, pushUpsNumber,  pressNumber, rearPushUpsNumber,  impactsNumber,  plankDuration);
//        try {
//            connectionClass.AddHomeTrain(homeExercises);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return true;
//    }
}


