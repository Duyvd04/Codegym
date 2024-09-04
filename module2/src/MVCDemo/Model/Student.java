package MVCDemo.Model;


public class Student extends Person {
    private String studentClass;

    public Student(String id, String name, int age, String studentClass) {
        super(id, name, age);
        this.studentClass = studentClass;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }
}

