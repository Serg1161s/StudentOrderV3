import answer.AnswerChildren;
import answer.AnswerCityRegister;
import answer.AnswerStudent;
import answer.AnswerWedding;

public class StudentOrderValidator {
    public static void main(String[] args) {
        checkAll();
    }
    static void  checkAll (){

        while (true) {
                StudentOrder so = readStudentOrder();
                if (so == null){
                    break;
                }
                AnswerCityRegister cityAnswer = checkCityRegister(so);
                if (!cityAnswer.success){
                    break;
                }

                AnswerWedding wedAnswer = checkWedding(so);
                AnswerChildren childAnswer = checkChildren(so);
                AnswerStudent studentAnswer = checkStudent(so);

                sendMail(so);
            }

    }
    static StudentOrder readStudentOrder (){
        StudentOrder so = new StudentOrder();
        return so;
    }
    static AnswerCityRegister checkCityRegister (StudentOrder so){
        CityRegisterValidator crv1 = new CityRegisterValidator();
        crv1.hostName = "host1";
        crv1.login = "login1";
        crv1.password = "Password1";
        CityRegisterValidator crv2 = new CityRegisterValidator();
        crv2.hostName = "host2";
        crv2.login = "login2";
        crv2.password = "Password2";
        AnswerCityRegister ans1 = crv1.checkCityRegister(so);
        AnswerCityRegister ans2 = crv2.checkCityRegister(so);
        return ans1;
    }
    static AnswerWedding checkWedding (StudentOrder so){
        return new WeddingValidator().checkWedding(so);
    }
    static AnswerChildren checkChildren (StudentOrder so){
        ChildrenValidator cv = new ChildrenValidator();
        return cv.checkChildren(so);
    }
    static AnswerStudent checkStudent (StudentOrder so){
        StudentValidator sv = new StudentValidator();
        return sv.checkStudent(so);
    }
    static void sendMail (StudentOrder so){
        new MailSender().sendMail(so);
    }
}
