package dao;

import connection.ConnectionDB;
import model.Classroom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassDAO implements IClassDAO{
    private static final String SELECT_ALL_CLASS = "select * from class";

    public ClassDAO() {
    }

    @Override
    public List<Classroom> selectAllClassroom() {
        List<Classroom> classrooms = new ArrayList<>();
        try(Connection connection = ConnectionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CLASS)){
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                classrooms.add(new Classroom(id,name));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return classrooms;
    }


}
