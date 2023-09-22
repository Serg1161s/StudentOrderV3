package edu.student_orden.register;

import java.util.ArrayList;
import java.util.List;

public class AnswerCityRegister {
    private List<AnswerCityRegisterItem> items;
    public void addItem (AnswerCityRegisterItem item){
        if (items == null){
            items = new ArrayList<>(10);
        }
        items.add(item);
    }
    public List<AnswerCityRegisterItem> getItem(){
        return items;
    }


}