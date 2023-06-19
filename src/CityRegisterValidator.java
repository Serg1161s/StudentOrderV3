import answer.AnswerCityRegister;

public class CityRegisterValidator {

    String hostName;
    String login;
    String password;
   public AnswerCityRegister checkCityRegister (StudentOrder so){
        System.out.println( " City Register is running - " +
                "hostNme: " + hostName +
                "login: " + login +
                "Password: " + password);
        AnswerCityRegister ans = new AnswerCityRegister();
        ans.success = false;
        return ans;
    }
}
