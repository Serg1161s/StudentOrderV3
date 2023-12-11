package edu.student_orden;

import edu.student_orden.dao.DictionaryDaoImpl;
import edu.student_orden.domain.wedding.*;

import java.time.LocalDate;
import java.util.List;

public class SaveStudentOrder {
    public static void main(String[] args) throws Exception {
        List<Street> streets = new DictionaryDaoImpl().findStreet("s");
        for (Street s:streets){
            System.out.println(s.getStreetName());
        }


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

        Street street = new Street(1L , "Заневский пр." );

        Address address = new Address("19500", street, "12","","142");

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

        Child child1 = new Child("Петрова", "Ирина", "Викторовна",LocalDate.of(2018,6,29));
        child1.setCertificateNumber("" + (300000 + id));
        child1.setIssueDate(LocalDate.of(2018,7,19));
        child1.setIssueDepartment("Отдел ЗАЗС №" + id);
        child1.setAddress(address);
        Child child2 = new Child("Петрова", "Света", "Викторовна",LocalDate.of(2018,6,29));
        child2.setCertificateNumber("" + (300000 + id));
        child2.setIssueDate(LocalDate.of(2018,7,19));
        child2.setIssueDepartment("Отдел ЗАЗС №" + id);
        child2.setAddress(address);

        so.setHusband(husband);
        so.setWife(wife);
        so.addChild(child1);
        so.addChild(child2);
     //   printStudentOrder(so);
        return so;
    }
    static void printStudentOrder (StudentOrder so){
        System.out.println(so.getStudentOrderId());
        System.out.println(so.getHusband());
    }

}
