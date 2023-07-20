package edu.student_orden.validator.register;

import edu.student_orden.register.CityRegisterResponse;
import edu.student_orden.wedding.Person;
import edu.student_orden.exaption.CityRegisterException;

public interface CityRegisterChecker
{

    CityRegisterResponse checkPerson(Person person) throws CityRegisterException;

}
