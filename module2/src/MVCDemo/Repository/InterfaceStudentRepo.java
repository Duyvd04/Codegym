package MVCDemo.Repository;


import MVCDemo.Model.Student;
import java.util.List;

public interface InterfaceStudentRepo {
    void addStudent(Student student);
    void removeStudent(String id);
    Student getStudentById(String id);
    List<Student> getAllStudents();
}

