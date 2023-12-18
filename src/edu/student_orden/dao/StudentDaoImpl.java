package edu.student_orden.dao;

import edu.student_orden.config.Config;
import edu.student_orden.domain.wedding.Street;
import edu.student_orden.domain.wedding.StudentOrder;
import edu.student_orden.domain.wedding.StudentOrderStatus;
import edu.student_orden.exaption.DaoException;

import java.sql.*;

public class StudentDaoImpl implements StudentOrderDao
{
        private static final String INSERT_ORDER =
                "INSERT INTO public.jc_student_order( " +
                        " student_order_status, student_order_date," +
                        " h_sur_name, h_given_name, h_patronymic, h_date_of_birthday," +
                        " h_passport_seria, h_passport_number, h_passport_date, h_passport_office_id," +
                        " h_post_index, h_street_code, h_building, h_extension, h_apartment, w_sur_name," +
                        " w_given_name, w_patronymic, w_date_of_birthday, w_passport_seria, w_passport_number, " +
                        "w_passport_date, w_passport_office_id, w_post_index, w_street_code, w_building," +
                        " w_extension, w_apartment, certificate_id, register_office_id, marriage_date)" +
                        " VALUES (?, ?, ?," +
                        " ?, ?, ?, ?," +
                        " ?, ?, ?, ?, " +
                        "?, ?, ?, ?, ?, ?," +
                        " ?, ?, ?, ?, ?, " +
                        "?, ?, ?, ?, ?," +
                        " ?, ?, ?, ?, ?);";
    //TODO one implementation
    private Connection getConnection() throws SQLException {
        // Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection(
                Config.getProperty(Config.DB_URL),
                Config.getProperty(Config.DB_LOGIN),
                Config.getProperty(Config.DB_PASSWORD)
        );
        return conn;
    }

    @Override
    public Long saveStudentOrder(StudentOrder so) throws DaoException {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_ORDER)) {
            stmt.setInt(1, StudentOrderStatus.START.ordinal());
            stmt.setTimestamp(2,java.sql.Timestamp.valueOf(so.getStudentOrderDate()));
            stmt.setString(3, so.getHusband().getSurName());
            stmt.setString(4, so.getHusband().getGivenName());
            stmt.setString(5, so.getHusband().getPatronymic());
            stmt.setDate(6, java.sql.Date.valueOf(so.getHusband().getDateOfBirth()));
            stmt.setString(7, so.getHusband().getPassportSeria() );
            stmt.setString(8,so.getHusband().getPassportNumber());
            stmt.setDate(9, java.sql.Date.valueOf(so.getHusband().getIssueDate()) );
            stmt.setLong(10, so.getHusband().getIssueDepartment().getOfficeId());
            stmt.setString(11,so.getHusband().getAddress().getPostCode()); // TODO Maybe not correct h_post_index
            stmt.setLong(12,so.getHusband().getAddress().getStreet().getStreetCode());
            stmt.setString(13, so.getHusband().getAddress().getBuilding());
            stmt.setString(14,so.getHusband().getAddress().getExtension());
            stmt.setString(15, so.getHusband().getAddress().getApartment());
            stmt.setTimestamp(16,java.sql.Timestamp.valueOf(so.getStudentOrderDate()));
            stmt.setString(17, so.getWife().getSurName());
            stmt.setString(18, so.getWife().getGivenName());
            stmt.setString(19, so.getWife().getPatronymic());
            stmt.setDate(20, java.sql.Date.valueOf(so.getHusband().getDateOfBirth()));
            stmt.setString(21, so.getWife().getPassportSeria() );
            stmt.setString(22, so.getWife().getPassportNumber());
            stmt.setDate(23, java.sql.Date.valueOf(so.getHusband().getIssueDate()) );
            stmt.setLong(24,   so.getWife().getIssueDepartment().getOfficeId());
            stmt.setString(25, so.getWife().getAddress().getPostCode()); // TODO Maybe not correct h_post_index
            stmt.setLong(26,   so.getWife().getAddress().getStreet().getStreetCode());
            stmt.setString(27, so.getWife().getAddress().getBuilding());
            stmt.setString(28,so.getWife().getAddress().getExtension());
            stmt.setString(29, so.getWife().getAddress().getApartment());
            stmt.setString(30, so.getMarriageCertificateID());
            stmt.setLong(31, so.getMarriageOffice().getOfficeId());
            stmt.setDate(32, java.sql.Date.valueOf(so.getMarriageDate()));
//                   "certificate_id," +
//                    " register_office_id," +
//                    " marriage_date)"
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }

        return 0l;
    }
}
