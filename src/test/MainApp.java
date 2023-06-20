package test;

public class MainApp  {
    public static void main(String[] args) {
        int num = createNumber();
        printNumber(num);
    }


    static int createNumber (){
        return new CreatNumber().createNumber();
    }
    static void printNumber(int num){
        PrintNumber printNum = new PrintNumber();
        printNum.printNumber(num);
    }
}
