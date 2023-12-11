package edu.student_orden.dao;

import edu.student_orden.config.Config;
import edu.student_orden.domain.wedding.Street;
import edu.student_orden.exaption.DaoException;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DictionaryDaoImpl implements DictionaryDao
{
    private static final String GET_STREET = "SELECT street_code, street_name " +
            "FROM st_street WHERE UPPER(street_name)" + "LIKE UPPER(?)";

    private Connection getConnection() throws SQLException {
        // Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection(
                Config.getProperty(Config.DB_URL),
                Config.getProperty(Config.DB_LOGIN),
                Config.getProperty(Config.DB_PASSWORD)
        );
        return conn;
    }

    public List<Street> findStreet(String pattern) throws DaoException {
        List<Street> results = new LinkedList<>();

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(GET_STREET)) {
            stmt.setString(1, "%" + pattern + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Street str = new Street(rs.getLong("street_code"), rs.getString("street_name"));
                results.add(str);
            }
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
        return results;
    }

}
