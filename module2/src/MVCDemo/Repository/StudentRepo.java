package MVCDemo.Repository;


import MVCDemo.Model.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentRepo implements InterfaceStudentRepo {
    private List<Student> students = new ArrayList<>();

    @Override
    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public void removeStudent(String id) {
        students.removeIf(student -> student.getId().equals(id));
    }

    @Override
    public Student getStudentById(String id) {
        return students.stream().filter(student -> student.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Student> getAllStudents() {
        return students;
    }
}

