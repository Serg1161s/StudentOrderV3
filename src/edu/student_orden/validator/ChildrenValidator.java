package edu.student_orden.validator;

import edu.student_orden.children.AnswerChildren;
import edu.student_orden.wedding.StudentOrder;

public class ChildrenValidator {
     public AnswerChildren checkChildren (StudentOrder so){
        System.out.println("Children is running");
        return new AnswerChildren();
    }

}
