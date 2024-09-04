package MVCDemo.Controller;


import MVCDemo.Model.Teacher;
import MVCDemo.Service.InterfaceTeacherService;

import java.util.List;

public class TeacherController {
    private InterfaceTeacherService teacherService;

    public TeacherController(InterfaceTeacherService teacherService) {
        this.teacherService = teacherService;
    }

    public void addTeacher(String id, String name, int age, String subject) {
        Teacher teacher = new Teacher(id, name, age, subject);
        teacherService.hireTeacher(teacher);
    }

    public void removeTeacher(String id) {
        teacherService.fireTeacher(id);
    }

    public Teacher getTeacher(String id) {
        return teacherService.findTeacherById(id);
    }

    public List<Teacher> getAllTeachers() {
        return teacherService.listAllTeachers();
    }
}
