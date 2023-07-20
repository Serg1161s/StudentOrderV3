package edu.student_orden.validator;

import edu.student_orden.register.AnswerCityRegister;
import edu.student_orden.register.AnswerCityRegisterItem;
import edu.student_orden.validator.register.CityRegisterChecker;
import edu.student_orden.validator.register.FakeCityRegisterChecker;
import edu.student_orden.wedding.Child;
import edu.student_orden.register.CityRegisterResponse;
import edu.student_orden.wedding.Person;
import edu.student_orden.wedding.StudentOrder;
import edu.student_orden.exaption.CityRegisterException;

public class CityRegisterValidator {

   private CityRegisterChecker personChecker;

    public CityRegisterValidator() {
        personChecker = new FakeCityRegisterChecker();
    }

    public AnswerCityRegister checkCityRegister (StudentOrder so) {
        AnswerCityRegister ans = new AnswerCityRegister();
        ans.addItem(checkPerson(so.getHusband()));
        ans.addItem(checkPerson(so.getWife()));
        for (Child child: so.getChildren()){
            ans.addItem(checkPerson(child));
        }
        return ans;
    }
    
    private AnswerCityRegisterItem checkPerson (Person person){
                try {
                    CityRegisterResponse hans = personChecker.checkPerson(person);
                } catch (CityRegisterException e){
                    e.printStackTrace(System.out);
                }

                return null;
    }

}
