package edu.student_orden;

import edu.student_orden.domain.*;
import edu.student_orden.mail.MailSender;
import edu.student_orden.validator.ChildrenValidator;
import edu.student_orden.validator.CityRegisterValidator;
import edu.student_orden.validator.StudentValidator;
import edu.student_orden.validator.WeddingValidator;

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
        crv1.setHostName("host1");
        crv1.setLogin("login1");
        crv1.setPassword("Password1");
        AnswerCityRegister ans1 = crv1.checkCityRegister(so);

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
