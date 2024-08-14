package bai5.baitap.Student;

public class Student {
    public String name;
    public String classes;

    public Student(){}

    public void setName(String name){
        this.name=name;
    }

    public void setClasses(String classes){
        this.classes=classes;
    }

    public String toString() {
        return name + "  " + classes;
    }

}
