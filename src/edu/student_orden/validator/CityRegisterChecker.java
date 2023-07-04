package edu.student_orden.validator;

import edu.student_orden.domain.CityRegisterCheckerResponse;
import edu.student_orden.domain.Person;

public interface CityRegisterChecker
{

    CityRegisterCheckerResponse checkPerson(Person person);

}
