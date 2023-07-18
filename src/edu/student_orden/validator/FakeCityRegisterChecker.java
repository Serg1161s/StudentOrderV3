package edu.student_orden.validator;

import edu.student_orden.domain.Adult;
import edu.student_orden.domain.Child;
import edu.student_orden.domain.CityRegisterCheckerResponse;
import edu.student_orden.domain.Person;
import edu.student_orden.exaption.CityRegisterException;

public class FakeCityRegisterChecker implements CityRegisterChecker {
    private static final String GOOD_1 = "1000";
    private static final String GOOD_2 = "2000";
    private static final String BAD_1 = "1001";
    private static final String BAD_2 = "2001";
    private static final String ERROR_1 = "1002";
    private static final String ERROR_2 = "2002";

    public CityRegisterCheckerResponse checkPerson(Person person)
            throws CityRegisterException {
        CityRegisterCheckerResponse res = new CityRegisterCheckerResponse();
        if (person instanceof Adult){
            Adult t = (Adult) person;
            if (t.getPassportSeria().equals(GOOD_1)|| t.getPassportSeria().equals(GOOD_2)){
                res.setExisting(true);
                res.setTemporal(false);
            }
            if (t.getPassportSeria().equals(BAD_2)|| t.getPassportSeria().equals(BAD_2)){
                res.setExisting(false);
            }
            if (t.getPassportSeria().equals(ERROR_1)|| t.getPassportSeria().equals(ERROR_2)){
                CityRegisterException ex = new CityRegisterException("Fake Error" + t.getPassportSeria());
                    throw ex;

            }

        }
        if (person instanceof Child){

            res.setExisting(true);
            res.setTemporal(true);

        }
        System.out.println(res);
        return  res;
    }
}
