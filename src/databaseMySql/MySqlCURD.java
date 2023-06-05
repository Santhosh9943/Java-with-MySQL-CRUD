package databaseMySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MySqlCURD {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/crud?characterEncoding=utf8";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "0000";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                while (true) {
                    System.out.println("MySQL Java CRUD Operation");
                    System.out.println("Choose the Operation:");
                    System.out.println("1. Insert");
                    System.out.println("2. Update");
                    System.out.println("3. Delete");
                    System.out.println("4. Select");
                    System.out.println("5. Exit");
                    System.out.print("Enter your choice: ");
                    int choice = scanner.nextInt();
                    System.out.println("-----------------------------------------");

                    switch (choice) {
                        case 1:
                            System.out.println("1. Insert New Data");
                            insertData(connection, scanner);
                            break;
                        case 2:
                            System.out.println("2. Update Data");
                            updateData(connection, scanner);
                            break;
                        case 3:
                            System.out.println("3. Delete Data");
                            deleteData(connection, scanner);
                            break;
                        case 4:
                            System.out.println("4. Print all Records");
                            selectData(connection);
                            break;
                        case 5:
                            System.out.println("Thank You");
                            return;
                        default:
                            System.out.println("Invalid Selection");
                            break;
                    }

                    System.out.println("-----------------------------------------");
                }
            } catch (SQLException e) {
                System.out.println("An error occurred while connecting to the database.");
                e.printStackTrace();
            }
        }
    }

    private static void insertData(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter Name: ");
        String name = scanner.next();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        System.out.print("Enter City: ");
        String city = scanner.next();

        String query = "INSERT INTO users (NAME, AGE, CITY) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setString(3, city);
            statement.executeUpdate();
            System.out.println("Data Inserted Successfully");
        }
    }

    private static void updateData(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        System.out.print("Enter City: ");
        String city = scanner.next();

        String query = "UPDATE users SET NAME = ?, AGE = ?, CITY = ? WHERE ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setString(3, city);
            statement.setInt(4, id);
            statement.executeUpdate();
            System.out.println("Data Updated Successfully");
        }
    }

    private static void deleteData(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();

        String query = "DELETE FROM users WHERE ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Data Deleted Successfully");
        }
    }

    private static void selectData(Connection connection) throws SQLException {
        String query = "SELECT * FROM users";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            System.out.printf("%-2s  %-20s  %-3s  %-10s%n", "ID", "Name", "Age", "City");
            System.out.println("----------------------------------------");
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                int age = resultSet.getInt("AGE");
                String city = resultSet.getString("CITY");
                System.out.printf("%-2d  %-20s  %-3d  %-10s%n", id, name, age, city);
            }
        }
    }


}
