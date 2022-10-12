package dao;

import connection.ConnectionDB;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IStudentDAO {
    private static final String INSERT_STUDENT_SQL = "insert into students(name, birthday, address, phone, email, classroom_id) values (?,?,?,?,?,?)";
    private static final String SELECT_STUDENT_BY_ID = "select * from students where id = ?";
    private static final String SELECT_ALL_STUDENTS = "select * from students";
    private static final String DELETE_STUDENT_SQL = "delete from students where id = ?";
    private static final String UPDATE_STUDENT_SQL = "update students set name = ?, birthday = ?, address = ?, phone = ?, email = ?, classroom_id = ? where id = ?";
    private static final String SELECT_BY_NAME = "select * from students where name like ?;";

    @Override
    public void insertStudent(Student student) throws SQLException {
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL)) {

            preparedStatement.setString(1, student.getName());
            preparedStatement.setDate(2, student.getBirthday());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, student.getPhoneNumber());
            preparedStatement.setString(5, student.getEmail());
            preparedStatement.setString(6, student.getClassroom_id());
            System.out.println(preparedStatement);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        }

    }

    @Override
    public Student selectStudent(int id) {
        Student student = null;
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                Date birthday = rs.getDate("birthday");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phoneNumber");
                String email = rs.getString("email");
                String classroom_id = rs.getString("classroom_id");

                student = new Student(name, birthday, address, phoneNumber, email, classroom_id);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return student;
    }

    @Override
    public List<Student> selectAllStudent() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Date birthday = rs.getDate("birthday");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phoneNumber");
                String email = rs.getString("email");
                String classroom_id = rs.getString("classroom_id");
                students.add(new Student(id, name, birthday, address, phoneNumber, email, classroom_id));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }

    @Override
    public boolean deleteStudent(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT_SQL)) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateStudent(Student student) throws SQLException {
        boolean rowUpdate;
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT_SQL)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, String.valueOf(student.getBirthday()));
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, student.getPhoneNumber());
            preparedStatement.setString(5, student.getEmail());
            preparedStatement.setString(6, String.valueOf(student.getClassroom_id()));

            rowUpdate = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdate;
    }

    @Override
    public List<Student> searchByName(String name) {
        List<Student> students = new ArrayList<>();
        Connection con = ConnectionDB.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(SELECT_BY_NAME);
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String names = rs.getString("name");
                Date birthday = rs.getDate("birthday");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phoneNumber");
                String email = rs.getString("email");
                String classroom_id = rs.getString("classroom_id");
                students.add(new Student(id, names, birthday, address, phoneNumber, email, classroom_id));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return students;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
