package edu.student_orden;

import edu.student_orden.dao.DictionaryDaoImpl;
import edu.student_orden.dao.StudentDaoImpl;
import edu.student_orden.dao.StudentOrderDao;
import edu.student_orden.domain.wedding.*;

import java.time.LocalDate;
import java.util.List;

public class SaveStudentOrder {
    public static void main(String[] args) throws Exception {
//        List<Street> streets = new DictionaryDaoImpl().findStreet("пе");
//        for (Street s:streets){
//            System.out.println(s.getStreetName());
//        }
//        List<RegisterOffice> registerOffices = new DictionaryDaoImpl().findRegisterOffice("020020010000");
//        for (RegisterOffice s:registerOffices){
//            System.out.println(s.getOfficeName());
//        }
//        List<PassportOffice> passportOffices = new DictionaryDaoImpl().findPassportOffice("010010000000");
//        for (PassportOffice s:passportOffices){
//            System.out.println(s.getOfficeName());
//        }
//        List<CountryArea> countryArea1 = new DictionaryDaoImpl().findArea("");
//        for (CountryArea c:countryArea1){
//            System.out.println(c.getAreaID() + ":" + c.getAreaName());
//        }
        System.out.println("________");
        List<CountryArea> countryArea2 = new DictionaryDaoImpl().findArea("020000000000");
        for (CountryArea c:countryArea2){
            System.out.println(c.getAreaID() + ":" + c.getAreaName());
        }
//        System.out.println("________");
//        List<CountryArea> countryArea3 = new DictionaryDaoImpl().findArea("020010000000");
//        for (CountryArea c:countryArea3){
//            System.out.println(c.getAreaID() + ":" + c.getAreaName());
//        }
//        System.out.println("________");
//        List<CountryArea> countryArea4 = new DictionaryDaoImpl().findArea("020010010000");
//        for (CountryArea c:countryArea4){
//            System.out.println(c.getAreaID() + ":" + c.getAreaName());
//        }

        StudentOrder s = buildStudentOrder(10);
        StudentOrderDao dao = new StudentDaoImpl();
        Long id = dao.saveStudentOrder(s);
        System.out.println(id);

//        StudentOrder so = new StudentOrder();
//        long ans = saveStudentOrder (so);
//        System.out.println("Student Order saved");
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
        RegisterOffice ro1 = new RegisterOffice(1L,"","" );
        so.setMarriageOffice(ro1);

        Street street = new Street(1L , "Заневский пр." );

        Address address = new Address("19500", street, "12","","142");

        Adult husband = new Adult("Петров", "Виктор", "Сергеевич", LocalDate.of(1997,8,24));
        husband.setPassportSeria("" + (1000+id));
        husband.setPassportNumber("" + (10000 + id));
        husband.setIssueDate(LocalDate.of(2017,9,15));
        PassportOffice po1 = new PassportOffice(1L,"","" );
        husband.setIssueDepartment(po1);
        husband.setStudentId("" + (100000 + id));
        husband.setAddress(address);
        husband.setUniversity(new University(2l,""));
        husband.setStudentId("HHH1234");


        Adult wife = new Adult("Петрова", "Вероника", "Алексевна", LocalDate.of(1998,3,12));
        wife.setPassportSeria("" + (2000+id));
        wife.setPassportNumber("" + (20000 + id));
        wife.setIssueDate(LocalDate.of(2018,4,5));
        PassportOffice po2 = new PassportOffice(1L,"","" );
        wife.setIssueDepartment(po2);
        wife.setStudentId("" + (200000 + id));
        wife.setAddress(address);
        wife.setUniversity(new University(1L, ""));
        wife.setStudentId("WW12345");

        Child child1 = new Child("Петрова", "Ирина", "Викторовна",LocalDate.of(2018,6,29));
        child1.setCertificateNumber("" + (300000 + id));
        child1.setIssueDate(LocalDate.of(2018,7,19));
        RegisterOffice ro2 = new RegisterOffice(1L,"","" );
        child1.setIssueDepartment(ro2);
        child1.setAddress(address);
        Child child2 = new Child("Петрова", "Света", "Викторовна",LocalDate.of(2018,6,29));
        child2.setCertificateNumber("" + (300000 + id));
        child2.setIssueDate(LocalDate.of(2018,7,19));
        RegisterOffice ro3 = new RegisterOffice(1L,"","" );
        child2.setIssueDepartment(ro3);
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
