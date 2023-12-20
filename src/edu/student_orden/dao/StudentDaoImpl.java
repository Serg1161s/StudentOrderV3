package edu.student_orden.dao;

import edu.student_orden.config.Config;
import edu.student_orden.domain.wedding.*;
import edu.student_orden.exaption.DaoException;

import java.sql.*;
import java.time.LocalDateTime;

public class StudentDaoImpl implements StudentOrderDao
{
        private static final String INSERT_ORDER =
                "INSERT INTO jc_student_order("+
                        "student_order_status, student_order_date, " +
                        "h_sur_name, h_given_name, h_patronymic, h_date_of_birthday, " +
                        "h_passport_seria, h_passport_number, h_passport_date, h_passport_office_id, " +
                        "h_post_index, h_street_code, h_building, h_extension, h_apartment, w_sur_name, " +
                        "w_given_name, w_patronymic, w_date_of_birthday, w_passport_seria, w_passport_number, " +
                        "w_passport_date, w_passport_office_id, w_post_index, w_street_code, w_building, " +
                        "w_extension, w_apartment, certificate_id, register_office_id, marriage_date)" +
                        "VALUES (?, ?," +
                        "?, ?, ?, ?," +
                        "?, ?, ?, ?, " +
                        "?, ?, ?, ?, ?, ?," +
                        "?, ?, ?, ?, ?, " +
                        "?, ?, ?, ?, ?," +
                        "?, ?, ?, ?, ?);";

    private static final String INSERT_CHID =
            "INSERT INTO jc_student_child(student_order_id, c_sur_name, c_given_name," +
                    " c_patronymic, c_date_of_birthday, c_certificate_number, c_certificate_date," +
                    " c_register_office_id, c_post_index, c_street_code, c_building, c_extension, c_apartment)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

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
        Long result = -1L;
        try (Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(INSERT_ORDER, new String[] {"student_order_id"})) {
            conn.setAutoCommit(false); // управляем транзакцией вручную

            try {
                // Header
                stmt.setInt(1, StudentOrderStatus.START.ordinal());
                stmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
                //Husband and wife
                setParamForAdult(stmt, 3, so.getHusband());
                setParamForAdult(stmt,16, so.getWife());
                // Marriage
                stmt.setString(29, so.getMarriageCertificateID());
                stmt.setLong(30, so.getMarriageOffice().getOfficeId());
                stmt.setDate(31, Date.valueOf(so.getMarriageDate()));

                stmt.executeUpdate();
                ResultSet gkRs = stmt.getGeneratedKeys();
                if (gkRs.next()) {
                   result = gkRs.getLong(1);
                }
                gkRs.close(); // на всякий случай
                saveChildren (conn, so, result);
                conn.commit(); // Если транзакция прошла, изменяем в базе данных

            } catch (SQLException e) {
                conn.rollback(); // Вернуьт транзакцию при сбое
                throw e;
            }

        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
        return result;
    }

    private void saveChildren(Connection conn, StudentOrder so, Long soId) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement((INSERT_CHID))) {
            int counter = 0;
            for (Child child : so.getChildren()) {
                stmt.setLong(1, soId);
                setParamForChild(stmt,child);
                stmt.addBatch(); // Копим заявки, что бы отправить одним BATch, для более быстрой записи. по одному файлу долго
                counter++; //счётчик для подсчёта заявок, для отправки по достижению определённого колличества
                if (counter > 1){
                    stmt.executeBatch();
                    counter = 0;
                }
            }
            if (counter > 0) {
                stmt.executeBatch(); // Отправляем заявки если в конце сеанса не набралось нужного колличества
            }
        }
    }

    private void setParamForAdult(PreparedStatement stmt, int start, Adult adult) throws SQLException {
        setParamsForPerson(stmt, start, adult);
        stmt.setString(start +4, adult.getPassportSeria() );
        stmt.setString(start +5, adult.getPassportNumber());
        stmt.setDate(  start +6, Date.valueOf(adult.getIssueDate()) );
        stmt.setLong(  start +7, adult.getIssueDepartment().getOfficeId());
        setParamForAddress(stmt, start+8, adult);
    }
    private void setParamForChild(PreparedStatement stmt, Child child) throws  SQLException{
        setParamsForPerson(stmt,2,child);
        stmt.setString(6, child.getCertificateNumber());
        stmt.setDate(  7,  Date.valueOf(child.getIssueDate()) );
        stmt.setLong(8, child.getIssueDepartment().getOfficeId());
        setParamForAddress(stmt,9,child);
    }
    private static void setParamsForPerson(PreparedStatement stmt, int start, Person person) throws SQLException {
        stmt.setString(start +0, person.getSurName());
        stmt.setString(start +1, person.getGivenName());
        stmt.setString(start +2, person.getPatronymic());
        stmt.setDate(  start +3, Date.valueOf(person.getDateOfBirth()));
    }
    private void setParamForAddress (PreparedStatement stmt, int start, Person person) throws SQLException {
        Address addult_address = person.getAddress();
        stmt.setString(start +0,  addult_address.getPostCode());
        stmt.setLong(  start +1,  addult_address.getStreet().getStreetCode());
        stmt.setString(start +2, addult_address.getBuilding());
        stmt.setString(start +3, addult_address.getExtension());
        stmt.setString(start +4, addult_address.getApartment());
    }
}
