package MVCDemo.Service;


import MVCDemo.Model.Student;
import java.util.List;

public interface InterfaceStudentService {
    void registerStudent(Student student);
    void expelStudent(String id);
    Student findStudentById(String id);
    List<Student> listAllStudents();
}

