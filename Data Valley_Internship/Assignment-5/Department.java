import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Department {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/departments";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    public void saveDepartment(Department department) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "INSERT INTO department (id, name) VALUES (?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, department.getId());
            preparedStatement.setString(2, department.getName());
            preparedStatement.executeUpdate();
            System.out.println("Department saved successfully.");
        } catch (SQLException e) {
            System.err.println("Error occurred while saving department: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Example usage:
        DepartmentDAO departmentDAO = new DepartmentDAO();
        Department department = new Department(1, "IT");
        departmentDAO.saveDepartment(department);
    }
}

class Department {
    private int id;
    private String name;

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
