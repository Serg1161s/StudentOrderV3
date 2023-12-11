package edu.student_orden.dao;

import edu.student_orden.domain.wedding.Street;
import edu.student_orden.exaption.DaoException;

import java.util.LinkedList;
import java.util.List;

public interface DictionaryDao {
   List<Street> findStreet(String pattern)throws DaoException;
}
