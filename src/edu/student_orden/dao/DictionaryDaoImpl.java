package edu.student_orden.dao;

import edu.student_orden.config.Config;
import edu.student_orden.domain.wedding.PassportOffice;
import edu.student_orden.domain.wedding.RegisterOffice;
import edu.student_orden.domain.wedding.Street;
import edu.student_orden.exaption.DaoException;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DictionaryDaoImpl implements DictionaryDao
{
    private static final String GET_STREET = "SELECT street_code, street_name " +
            "FROM jc_street WHERE UPPER(street_name)" + "LIKE UPPER(?)";
    private static final String GET_REGISTER_OFFICE = "SELECT * " +
            "FROM jc_register_office WHERE r_office_area_id=?";
    private static final String GET_PASSPORT_OFFICE = "SELECT * " +
            "FROM jc_passport_office WHERE p_office_area_id=?";
    private Connection getConnection() throws SQLException {
        // Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection(
                Config.getProperty(Config.DB_URL),
                Config.getProperty(Config.DB_LOGIN),
                Config.getProperty(Config.DB_PASSWORD)
        );
        return conn;
    }

    public List<Street> findStreet(String areaId) throws DaoException {
        List<Street> results = new LinkedList<>();

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(GET_STREET)) {
            stmt.setString(1, "%" + areaId + "%");
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

    @Override
    public List<PassportOffice> findPassportOffice(String areaId) throws DaoException {
        List<PassportOffice> results = new LinkedList<>();

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(GET_PASSPORT_OFFICE)) {
            stmt.setString(1, areaId );
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                PassportOffice str = new PassportOffice(rs.getLong("p_office_id"), rs.getString("p_office_area_id"), rs.getString("p_office_name"));
                results.add(str);
            }
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
        return results;
    }

    @Override
    public List<RegisterOffice> findRegisterOffice(String areaId) throws DaoException {
        List<RegisterOffice> results = new LinkedList<>();

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(GET_REGISTER_OFFICE)) {
            stmt.setString(1, areaId );
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                while (rs.next()) {
                    RegisterOffice str = new RegisterOffice(rs.getLong("r_office_id"), rs.getString("r_office_area_id"), rs.getString("r_office_name"));
                    results.add(str);
                }
            }
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
        return results;
    }

}
