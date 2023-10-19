package Week6;

import java.sql.*;
public class DatabaseAppWithJDBC {

    public static final String DB_URL = "jdbc:mysql://localhost/employee";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "mysql";

    public static void main(String[] args) {
        Connection connection = null;
        String sql ="SELECT * FROM employees";

        try {
            connection = DriverManager.getConnection(DB_URL , DB_USER , DB_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet data = statement.executeQuery(sql);
            while (data.next()){
                System.out.println("ID : " + data.getInt("employees_id"));
                System.out.println("Name : " + data.getString("employees_name"));
                System.out.println("Position : " + data.getString("employees_position"));
                System.out.println("Salary : " + data.getInt("employees_salary"));
                System.out.println("=======================================================");
            }

        }catch (Exception e){

        }
    }

}
