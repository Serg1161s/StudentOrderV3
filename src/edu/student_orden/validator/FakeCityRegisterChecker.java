package edu.student_orden.validator;

import edu.student_orden.domain.CityRegisterCheckerResponse;
import edu.student_orden.domain.Person;
import edu.student_orden.exaption.CityRegisterException;

public class FakeCityRegisterChecker implements CityRegisterChecker {
    public CityRegisterCheckerResponse checkPerson(Person person) throws CityRegisterException {

        return  null;
    }
}
