import answer.AnswerChildren;
import answer.AnswerCityRegister;
import answer.AnswerStudent;
import answer.AnswerWedding;

public class StudentOrderValidator {
    public static void main(String[] args) {
        checkAll();
    }
    static void  checkAll (){
        StudentOrder so = readStudentOrder();

        AnswerCityRegister cityRegister = checkCityRegister (so);
        AnswerWedding wedAnswer = checkWedding (so);
        AnswerChildren childAnswer= checkChildren (so);
        AnswerStudent studentAnswer = checkStudent (so);

        sendMail(so);
    }
    static StudentOrder readStudentOrder (){
        StudentOrder so = new StudentOrder();
        return so;
    }
    static AnswerCityRegister checkCityRegister (StudentOrder so){
        System.out.println( " City Register is running ");
        AnswerCityRegister ans = new AnswerCityRegister();
        return ans;
    }
    static AnswerWedding checkWedding (StudentOrder so){
        System.out.println( " Wedding is running");
        AnswerWedding ans = new AnswerWedding();
        return ans;
    }
    static AnswerChildren checkChildren (StudentOrder so){
        System.out.println("Children is running");
        return new AnswerChildren();
    }
    static AnswerStudent checkStudent (StudentOrder so){
        System.out.println(" Student Order is Runing");
        return new AnswerStudent();
    }
    static void sendMail (StudentOrder so){
        System.out.println("Mail was sended");
    }
}
