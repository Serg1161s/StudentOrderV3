package edu.student_orden.dao;

import edu.student_orden.domain.wedding.StudentOrder;
import edu.student_orden.exaption.DaoException;

public interface StudentOrderDao
{
    Long saveStudentOrder (StudentOrder so) throws DaoException;
}
