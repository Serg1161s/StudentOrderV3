package edu.student_orden;

import edu.student_orden.domain.Address;
import edu.student_orden.domain.Adult;
import edu.student_orden.domain.Child;
import edu.student_orden.domain.StudentOrder;

import java.time.LocalDate;

public class SaveStudentOrder {
    public static void main(String[] args) {

        StudentOrder so = new StudentOrder();
        long ans = saveStudentOrder (so);
        System.out.println("Student Order saved");
    }
    static long saveStudentOrder (StudentOrder so){
        long ans = 199;
        System.out.println("save StudentOrder " );
        return ans;
    }

    static StudentOrder buildStudentOrder(long id){
        StudentOrder so = new StudentOrder();
        so.setStudentOrderId(id);
        so.setMarriageCertificateID("" + (123456000 + id));
        so.setMarriageDate(LocalDate.of(2016, 7,4));
        so.setMarriageOffice("Отдел ЗАГС");

        Address address = new Address("19500", "Заневский пр.", "12","","142");

        Adult husband = new Adult("Петров", "Виктор", "Сергеевич", LocalDate.of(1997,8,24));
        husband.setPassportSeria("" + (1000+id));
        husband.setPassportNumber("" + (10000 + id));
        husband.setIssueDate(LocalDate.of(2017,9,15));
        husband.setIssueDepartment("Отдел милиции №" + id);
        husband.setStudentId("" + (100000 + id));
        husband.setAddress(address);


        Adult wife = new Adult("Петрова", "Вероника", "Алексевна", LocalDate.of(1998,3,12));
        wife.setPassportSeria("" + (2000+id));
        wife.setPassportNumber("" + (20000 + id));
        wife.setIssueDate(LocalDate.of(2018,4,5));
        wife.setIssueDepartment("Отдел милиции №" + id);
        wife.setStudentId("" + (200000 + id));
        wife.setAddress(address);

        Child child = new Child("Петрова", "Ирина", "Викторовна",LocalDate.of(2018,6,29));
        child.setCertificateNumber("" + (300000 + id));
        child.setIssueDate(LocalDate.of(2018,7,19));
        child.setIssueDepartment("Отдел ЗАЗС №" + id);
        child.setAddress(address);

        so.setHusband(husband);
        so.setWife(wife);
        so.setChild(child);
     //   printStudentOrder(so);
        return so;
    }
    static void printStudentOrder (StudentOrder so){
        System.out.println(so.getStudentOrderId());
        System.out.println(so.getHusband());
    }

}
