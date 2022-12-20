package databaseMySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class MySqlCURD {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/crud?characterEncoding=utf8";
		String username = "root";
		String password = "0000";
		Connection con = DriverManager.getConnection(url, username, password);

		Statement stmt = con.createStatement();
		ResultSet rs;
		PreparedStatement st;

		String qry = "";
		int id, age, choice;
		String name, city;

		try (Scanner in = new Scanner(System.in); Scanner str = new Scanner(System.in)) {
			while (true) {
				System.out.println("MySQL Java CRUD Operation");
				System.out.println("Choose the Number the Operation");
				System.out.println("1. Insert");
				System.out.println("2. Update");
				System.out.println("3. Delete");
				System.out.println("4. Select");
				System.out.println("5. Exit");
				System.out.print("Enter a choice: ");
				choice = in.nextInt();
				System.out.println("-----------------------------------------");
				switch (choice) {
				case 1:
					System.out.println("1. Insert New Data");

					System.out.println("Enter Name : ");
					name = str.nextLine();
					System.out.println("Enter Age : ");
					age = in.nextInt();
					System.out.println("Enter City : ");
					city = str.nextLine();

					qry = "insert into users (NAME,AGE,CITY) values(?,?,?)";
					st = con.prepareStatement(qry);
					st.setString(1, name);
					st.setInt(2, age);
					st.setString(3, city);

					st.executeUpdate();
					System.out.println("Data Insert Success");

					break;
				case 2:
					System.out.println("2. Updating a Data");

					System.out.println("Enter ID : ");
					id = in.nextInt();
					System.out.println("Enter Name : ");
					name = str.nextLine();
					System.out.println("Enter Age : ");
					age = in.nextInt();
					System.out.println("Enter City : ");
					city = str.nextLine();

					qry = "update users set NAME=?,AGE=?,CITY=? where ID=?";
					st = con.prepareStatement(qry);

					st.setString(1, name);
					st.setInt(2, age);
					st.setString(3, city);
					st.setInt(4, id);
					st.executeUpdate();
					System.out.println("Data Update Success");

					break;
				case 3:
					System.out.println("3. Deleting a Data");
					System.out.println("Enter ID : ");
					id = in.nextInt();

					qry = "delete from users where ID=?";
					st = con.prepareStatement(qry);
					st.setInt(1, id);

					st.executeUpdate();
					System.out.println("Data Deleted Success");

					break;
				case 4:
					System.out.println("4. Print all Records");
					qry = "SELECT ID,NAME,AGE,CITY from users";
					rs = stmt.executeQuery(qry);
					while (rs.next()) {
						id = rs.getInt("ID");
						name = rs.getString("NAME");
						age = rs.getInt("AGE");
						city = rs.getString("CITY");

						System.out.print(id + " ");
						System.out.print(name + " ");
						System.out.print(age + " ");
						System.out.println(city + " ");

					}
					break;
				case 5:
					System.out.println("Thank You");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Selection");
					break;
				}
				System.out.println("-----------------------------------------");
			}
		} catch (Exception e) {
			System.out.println("Enter correct Data type \n	  NOTE: \n		For Operation (Enter the Number of that Operation) \n		Type the \"id\"&\"Age\" in Numbers Only \n		Type the \"name\"&\"city\" in Letters \nExit and Run the Program again");
		}
	}

}
