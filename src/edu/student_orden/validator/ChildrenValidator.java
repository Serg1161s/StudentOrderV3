package edu.student_orden.validator;

import edu.student_orden.domain.AnswerChildren;
import edu.student_orden.domain.StudentOrder;

public class ChildrenValidator {
     public AnswerChildren checkChildren (StudentOrder so){
        System.out.println("Children is running");
        return new AnswerChildren();
    }

}
