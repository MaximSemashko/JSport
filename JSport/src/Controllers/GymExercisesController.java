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
import Exercises.GymExercises;

import java.io.IOException;

public class GymExercisesController {

    @FXML
    private TableView<GymExercises> GymTrain;

    @FXML
    private TableColumn<GymExercises, Integer> dayColumn;

    @FXML
    private TableColumn<GymExercises, Integer> setsColumn;

    @FXML
    private TableColumn<GymExercises, Integer> benchSquatsColumn;

    @FXML
    private TableColumn<GymExercises, Integer> barbellBenchPressColumn;

    @FXML
    private TableColumn<GymExercises, Integer> bentOverBarbellRowColumn;

    @FXML
    private TableColumn<GymExercises, Integer> dipsColumn;

    @FXML
    private Button LoadButton;

    @FXML
    private Button AddButton;

    @FXML
    private Button DeleteButton;

    @FXML
    private TextField benchSquatsAdd;

    @FXML
    private TextField barbellBenchPressAdd;

    @FXML
    private TextField bentOverBarbellRowAdd;

    @FXML
    private TextField dipsAdd;

    @FXML
    private Button toMainPage;

    @FXML
    private TextField dayAdd;

    @FXML
    private TextField setsAdd;

//List of data that we will add to db

    final ObservableList<GymExercises> data = FXCollections.observableArrayList();

    public void initialize() {
        dayColumn.setCellValueFactory(new PropertyValueFactory<GymExercises, Integer>("days"));
        setsColumn.setCellValueFactory(new PropertyValueFactory<GymExercises, Integer>("sets"));
        benchSquatsColumn.setCellValueFactory(new PropertyValueFactory<GymExercises, Integer>("BenchSquats"));
        barbellBenchPressColumn.setCellValueFactory(new PropertyValueFactory<GymExercises, Integer>("BarbellBenchPress"));
        bentOverBarbellRowColumn.setCellValueFactory(new PropertyValueFactory<GymExercises, Integer>("BentOverBarbellRow"));
        dipsColumn.setCellValueFactory(new PropertyValueFactory<GymExercises, Integer>("Dips"));


        //use method getHomeExercises()

        GymTrain.setItems(getGymExercises());

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

    private ObservableList<GymExercises> getGymExercises() {
        ObservableList<GymExercises> gymExercises = FXCollections.observableArrayList();
        gymExercises.add(new GymExercises(1, 2, 3, 4, 5, 6));
        return gymExercises;
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
        GymExercises gymEx = new GymExercises();
        gymEx.setDays(Integer.parseInt(dayAdd.getText()));
        gymEx.setSets(Integer.parseInt(setsAdd.getText()));
        gymEx.setBenchSquats(Integer.parseInt(benchSquatsAdd.getText()));
        gymEx.setBarbellBenchPress(Integer.parseInt(barbellBenchPressAdd.getText()));
        gymEx.setBentOverBarbellRow(Integer.parseInt(bentOverBarbellRowAdd.getText()));
        gymEx.setDips(Integer.parseInt(dipsAdd.getText()));
        GymTrain.getItems().add(gymEx);
        dayAdd.clear();
        setsAdd.clear();
        benchSquatsAdd.clear();
        barbellBenchPressAdd.clear();
        bentOverBarbellRowAdd.clear();
        dipsAdd.clear();
    }

        //Delete from table

        public void deleteButtonClick() {
            ObservableList<GymExercises> gymExercisesSelected, allGymExercises;
            allGymExercises = GymTrain.getItems();
            gymExercisesSelected = GymTrain.getSelectionModel().getSelectedItems();
            gymExercisesSelected.forEach(allGymExercises::remove);
        }

        //Method adds data to db

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


