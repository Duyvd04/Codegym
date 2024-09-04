package MVCDemo.Controller;


import MVCDemo.Model.Student;
import MVCDemo.Service.InterfaceStudentService;

import java.util.List;

public class StudentController {
    private InterfaceStudentService studentService;

    public StudentController(InterfaceStudentService studentService) {
        this.studentService = studentService;
    }

    public void addStudent(String id, String name, int age, String studentClass) {
        Student student = new Student(id, name, age, studentClass);
        studentService.registerStudent(student);
    }

    public void removeStudent(String id) {
        studentService.expelStudent(id);
    }

    public Student getStudent(String id) {
        return studentService.findStudentById(id);
    }

    public List<Student> getAllStudents() {
        return studentService.listAllStudents();
    }
}

