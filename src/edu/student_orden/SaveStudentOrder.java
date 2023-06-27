package edu.student_orden;

import edu.student_orden.domain.Adult;
import edu.student_orden.domain.StudentOrder;

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

        return so;
    }

}
