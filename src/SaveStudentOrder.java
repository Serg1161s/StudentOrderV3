public class SaveStudentOrder {
    public static void main(String[] args) {
        StudentOrder so = new StudentOrder();
        so.hFirstName = "Petr";
        so.hLastName = "Petrov";
        so.wFirstName = "Vera";
        so.wLastName = "Petrova";

        long ans = saveStudentOrder (so);
        System.out.println("Student Order saved");
    }
    static long saveStudentOrder (StudentOrder so){
        long ans = 199;
        System.out.println("save StudentOrder " + so.hLastName);
        return ans;
    }
}
