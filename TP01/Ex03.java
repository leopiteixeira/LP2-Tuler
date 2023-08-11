abstract class Person {
    private String name;
    private String address;

    public Person(String name, String address){
        this.name = name;
        this.address = address;
    } 

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString(){
        return String.format("Person[name=%s,address=%s]", this.name, this.address);
    }

}

class Student extends Person {
    private String program;
    private int year;
    private double fee;

    public Student(String name, String address, String program, int year, double fee){
        super(name, address);
        this.program = program;
        this.year = year;
        this.fee = fee;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString(){
        return String.format("Student[%s,program=%s,year=%d,fee=%.2f]", super.toString(), this.program, this.year, this.fee);
    }
}

class Staff extends Person{
    private String school;
    private double pay;

    public Staff(String name, String address, String school, double pay){
        super(name, address);
        this.school = school;
        this.pay = pay;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    @Override
    public String toString(){
        return String.format("Staff[%s,school=%s,pay=%.2f]", super.toString(), this.school, this.pay);
    }
}



public class Ex03 {
    public static void main(String[] args) {
        Student student1 = new Student("leo", "sao jose", "ADS", 2022, 2039.34);
        Staff staff1 = new Staff("gabriel", "sao vicente", "escola ai", 1400.34);

        
        System.out.println(student1.getName());
        System.out.println(student1.getAddress());
        System.out.println(student1.getProgram());
        System.out.println(student1.getYear());
        System.out.println(student1.getFee());
        student1.setAddress("endereco trocado");
        student1.setProgram("programa trocado");
        student1.setYear(1000);
        student1.setFee(4000.50);
        System.out.println(student1.toString());
        System.out.println(staff1.getName());
        System.out.println(staff1.getAddress());
        System.out.println(staff1.getSchool());
        System.out.println(staff1.getPay());
        staff1.setAddress("endereco trocado");
        staff1.setSchool("escola trocado");
        staff1.setPay(1000);
        System.out.println(staff1.toString());
    }
}
