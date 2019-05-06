package dao;

import model.User;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.Optional;
import org.apache.log4j.Logger;

public class UserDao {

    private static final Logger logger = Logger.getLogger(UserDao.class);
    Connection connection = DbConnector.connect();

//    public int addUser2(User user) {
//        Connection connection = DbConnector.connect();
//        try {
//            String sql = "INSERT INTO user(name, password, role) VALUES (?, ?, ?);";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, user.getName());
//            System.out.println(user.getName());
//            preparedStatement.setString(2, user.getPassword());
//            preparedStatement.setString(3, user.getRole());
//            System.out.println(user.getPassword());
//            preparedStatement.executeUpdate(sql);
//            logger.debug(sql);
//            return 1;
//        } catch (SQLException e) {
//            logger.error("Can't add user by name", e);
//            return 0;
//        }
//
//    }

    public int addUser(User user) {
        try {
            Statement statement = connection.createStatement();
            String name = user.getName();
            String password = user.getPassword();
            String role = user.getRole();
            String sql = "INSERT INTO madb.user(name, password, role) VALUES ('" + name + "','" + password + "','"+ role +"');";
            logger.debug(sql);
            int userAddedOrNo = statement.executeUpdate(sql);
            return userAddedOrNo;
        } catch (SQLException e) {
            logger.error("Can't add user by name", e);
            return 0;
        }
    }

//    public Optional<User> getUser(Long id) {
//        Connection connnection = DbConnector.connect();
//        try {
//            Statement statement = connnection.createStatement();
//            String sql = "SELECT * FROM madb.new_table WHERE id =" + id;
//            ResultSet resultSet = statement.executeQuery(sql);
//            while (resultSet.next()) {
//                Long userId = resultSet.getLong(1);
//                String name = resultSet.getString(2);
//                String password = resultSet.getString(3);
//                User user = new User(userId, name, password);
//                System.out.println(user);
//                return Optional.of(user);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return Optional.empty();
//    }

//    public Optional<User> getUser(String name) {
//        Connection connnection = DbConnector.connect();
//        try {
//            Statement statement = connnection.createStatement();
//            String sql = "SELECT * FROM madb.new_table WHERE name ='" + name + "'";
//            ResultSet resultSet = statement.executeQuery(sql);
//            while (resultSet.next()) {
//                Long userId = resultSet.getLong(1);
//                String nameUser = resultSet.getString(2);
//                String password = resultSet.getString(3);
//                User user = new User(userId, nameUser, password);
//                System.out.println(user);
//                return Optional.of(user);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return Optional.empty();
//    }

    public Optional<User> getUserByName(String name) {
        try {
            final String sql = "SELECT * FROM madb.user WHERE name = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            logger.debug(sql);
            if (resultSet.next()) {
                Long userId = resultSet.getLong(1);
                String nameUser = resultSet.getString(2);
                String password = resultSet.getString(3);
                String role = resultSet.getString(4);
                User user = new User(userId, nameUser, password, role);
                return Optional.of(user);
            }
        } catch (SQLException e) {
            logger.error("Can't get user by name ", e);
        }
        return Optional.empty();
    }

    public Optional<User> getUserById(Long id) {
        try {
            String sql = "SELECT * FROM madb.user WHERE id =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Long userId = resultSet.getLong(1);
                String nameUser = resultSet.getString(2);
                String password = resultSet.getString(3);
                String role = resultSet.getString(4);
                User user = new User(userId, nameUser, password, role);
                return Optional.of(user);
            }
        } catch (SQLException e) {
            logger.error("Can't get user by Id ", e);
        }
        return Optional.empty();
    }
}
