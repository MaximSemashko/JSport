package Database;
import Exercises.HomeExercises;
import sample.User;

import java.sql.*;

public class ConnectionClass {
    public Connection connection;

    public ConnectionClass() {
    }

    //Method to connect with database

    public Connection getConnection() {
        String dbName = "JSport";
        String userName = "root";
        String password = "12345";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, userName, password);
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        return this.connection;
    }


    /*Method for registration:
     Adds a user to a database*/

    public void signUpUser(User user) throws SQLException {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" +
                Const.USER_NAME + "," + Const.USER_SURNAME + "," +
                Const.USER_BIRTHDAY + "," + Const.USER_EMAIL + "," +
                Const.USER_LOGIN + "," + Const.USER_PASSWORD + ")" +
                "VALUES" +
                "( '" + user.getFirstName() +
                "','" + user.getLastName()  +
                "','" + user.getBirthday()  +
                "','" + user.getEmail()     +
                "','" + user.getUserName()  +
                "','" + user.getPassword()  +
                "')";
        Statement statement = connection.createStatement();
        statement.executeUpdate(insert);

    }

    //Method adds to homeExercises(db schema) concrete values

    public void AddHomeTrain(HomeExercises homeExercises) throws SQLException {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        String insertion="INSERT INTO HomeExercises VALUES "+"( '" + homeExercises.getDays() +
                "','" + homeExercises.getSets()  +
                "','" + homeExercises.getSquatsNumber()  +
                "','" + homeExercises.getPushUpsNumber()     +
                "','" + homeExercises.getPressNumber()  +
                "','" + homeExercises.getRearPushUpsNumber()  +
                "','" + homeExercises.getImpactsNumber()  +
                "','" + homeExercises.getPlankDuration()  +
                "')";
        Statement statement = connection.createStatement();
        statement.executeUpdate(insertion);

    }


    //Future method, that will take information about user form bd
    //??? How to take conrete user ???
    //Maybe i should use only method getUser?

    public void usersInfo(User user) throws SQLException {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        Statement statement = connection.createStatement();
        String sql = "SELECT  * FROM USER;";
        ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next()) {
            // this.textLabel.setText(resultSet.getString(1));
        }
    }

    //Method takes logins and passwords from db

    public ResultSet getUser(User user){
        ResultSet resSet = null;
        String select = "SELECT * FROM "+Const.USER_TABLE+" WHERE "+
                Const.USER_LOGIN+"=? AND "+Const.USER_PASSWORD+"=?";
        try {
            PreparedStatement prSt=getConnection().prepareStatement(select);
            prSt.setString(1,user.getUserName());
            prSt.setString(2,user.getPassword());
            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resSet;
    }

}
