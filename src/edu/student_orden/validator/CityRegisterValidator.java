package edu.student_orden.validator;

import edu.student_orden.domain.AnswerCityRegister;
import edu.student_orden.domain.Child;
import edu.student_orden.domain.CityRegisterCheckerResponse;
import edu.student_orden.domain.StudentOrder;
import edu.student_orden.exaption.CityRegisterException;

import java.util.Iterator;
import java.util.List;

public class CityRegisterValidator {

   private String hostName;
   private int port;
   private String login;
   private String password;
   private CityRegisterChecker personChecker;

    public CityRegisterValidator() {
        personChecker = new FakeCityRegisterChecker();
    }

    public AnswerCityRegister checkCityRegister (StudentOrder so){
        try {
            CityRegisterCheckerResponse hans = personChecker.checkPerson(so.getHusband());
            CityRegisterCheckerResponse wans = personChecker.checkPerson(so.getWife());
            List<Child> children = so.getChild();
            for (Iterator<Child> it = children.iterator(); it.hasNext();) {
                Child child = it.next();
                CityRegisterCheckerResponse cans = personChecker.checkPerson(child);
            }
        } catch (CityRegisterException e){
            e.printStackTrace(System.out);
        }
        AnswerCityRegister ans = new AnswerCityRegister();
       return ans;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
