package MVCDemo.Service;

import MVCDemo.Model.Student;
import MVCDemo.Repository.InterfaceStudentRepo;
import java.util.List;

public class StudentService implements InterfaceStudentService {
    private InterfaceStudentRepo studentRepo;

    public StudentService(InterfaceStudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public void registerStudent(Student student) {
        studentRepo.addStudent(student);
    }

    @Override
    public void expelStudent(String id) {
        studentRepo.removeStudent(id);
    }

    @Override
    public Student findStudentById(String id) {
        return studentRepo.getStudentById(id);
    }

    @Override
    public List<Student> listAllStudents() {
        return studentRepo.getAllStudents();
    }
}

