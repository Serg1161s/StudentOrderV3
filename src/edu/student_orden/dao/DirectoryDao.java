package edu.student_orden.dao;

import edu.student_orden.domain.wedding.Street;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DirectoryDao
{
    private Connection getConn () throws SQLException {
        // Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jc_student",
                "postgres", "postgre");
        return conn;
    }
    public List<Street>  findStreet (String pattern) throws Exception {
        List<Street> results = new LinkedList<>();

        Connection conn = getConn();
        Statement stmt = conn.createStatement();
        String sql = "SELECT street_code, street_name" +
                "From jc_street WHERE UPPER(street_name)" +
                " LIKE UPPER ('%" + pattern + "%')";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Street str = new Street(rs.getLong("street_code"), rs.getString("street_name"));
            results.add(str);
        }
        return results;
    }

}
