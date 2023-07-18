package edu.student_orden;

import edu.student_orden.domain.*;
import edu.student_orden.mail.MailSender;
import edu.student_orden.validator.ChildrenValidator;
import edu.student_orden.validator.CityRegisterValidator;
import edu.student_orden.validator.StudentValidator;
import edu.student_orden.validator.WeddingValidator;

public class StudentOrderValidator {
    public ChildrenValidator  childrenVal;
    public WeddingValidator  weddingVal;
    public StudentValidator studentVal;
    public MailSender mailSender;
    public CityRegisterValidator cityRegisterVal;


public StudentOrderValidator (){
    cityRegisterVal = new CityRegisterValidator();
    childrenVal = new ChildrenValidator();
    weddingVal = new WeddingValidator();
    studentVal = new StudentValidator();
    mailSender = new MailSender();
}


    public static void main(String[] args) {
        StudentOrderValidator sov = new StudentOrderValidator();
        sov.checkAll();
    }
    public void  checkAll () {
        StudentOrder[] soArray  = readStudentOrders();
        for (StudentOrder so:soArray) {
            System.out.println("");
            checkOneOrder(so);
        }
    }
    public StudentOrder[] readStudentOrders(){
        StudentOrder[] soArray = new StudentOrder[3];

        for (int c=0; c< soArray.length; c++) {
            soArray[c] = SaveStudentOrder.buildStudentOrder(c);
        }
        return soArray;
    }



    public void checkOneOrder (StudentOrder so){
        AnswerCityRegister cityAnswer = checkCityRegister(so);
//        AnswerWedding wedAnswer = checkWedding(so);
//        AnswerChildren childAnswer = checkChildren(so);
//        AnswerStudent studentAnswer = checkStudent(so);
//
//        sendMail(so);
    }

    public AnswerCityRegister checkCityRegister (StudentOrder so){
        return cityRegisterVal.checkCityRegister(so);
    }
    public AnswerWedding checkWedding (StudentOrder so){
        return weddingVal.checkWedding(so);
    }
    public AnswerChildren checkChildren (StudentOrder so){
        return childrenVal.checkChildren(so);
    }
    public AnswerStudent checkStudent (StudentOrder so){
        return studentVal.checkStudent(so);
    }
    public void sendMail (StudentOrder so){
        mailSender.sendMail(so);
    }
}
