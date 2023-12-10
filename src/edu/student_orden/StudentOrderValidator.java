package edu.student_orden;

import edu.student_orden.domain.children.AnswerChildren;
import edu.student_orden.mail.MailSender;
import edu.student_orden.domain.register.AnswerCityRegister;
import edu.student_orden.domain.student.AnswerStudent;
import edu.student_orden.domain.student.AnswerWedding;
import edu.student_orden.validator.ChildrenValidator;
import edu.student_orden.validator.CityRegisterValidator;
import edu.student_orden.validator.StudentValidator;
import edu.student_orden.validator.WeddingValidator;
import edu.student_orden.domain.wedding.StudentOrder;

import java.util.LinkedList;
import java.util.List;

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
        List<StudentOrder> soList  = readStudentOrders();
        for (StudentOrder so:soList) {
            checkOneOrder(so);
        }
    }
    public List<StudentOrder> readStudentOrders(){
        List<StudentOrder> soList = new LinkedList<>();

        for (int c=0; c< 5; c++) {
           StudentOrder so = SaveStudentOrder.buildStudentOrder(c);
           soList.add(so);
        }
        return soList;
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
