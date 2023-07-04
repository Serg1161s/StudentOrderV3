package edu.student_orden.validator;

import edu.student_orden.domain.CityRegisterCheckerResponse;
import edu.student_orden.domain.Person;

public class FakeCityRegisterChecker implements CityRegisterChecker {
    public CityRegisterCheckerResponse checkPerson(Person person){

        return  null;
    }
}
