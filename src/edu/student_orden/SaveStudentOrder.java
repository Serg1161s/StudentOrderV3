package edu.student_orden;

import edu.student_orden.domain.StudentOrder;

public class SaveStudentOrder {
    public static void main(String[] args) {
        StudentOrder so = new StudentOrder();
        so.sethFirstName("Petr");
        so.sethLastName("Petrov");
        so.setwFirstName("Vera");
        so.setwLastName("Petrova");

        long ans = saveStudentOrder (so);
        System.out.println("Student Order saved");
    }
    static long saveStudentOrder (StudentOrder so){
        long ans = 199;
        System.out.println("save StudentOrder " + so.getwLastName());
        return ans;
    }
}
