package MVCDemo.Service;


import MVCDemo.Model.Teacher;
import MVCDemo.Repository.InterfaceTeacherRepo;
import java.util.List;

public class TeacherService implements InterfaceTeacherService {
    private InterfaceTeacherRepo teacherRepo;

    public TeacherService(InterfaceTeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    @Override
    public void hireTeacher(Teacher teacher) {
        teacherRepo.addTeacher(teacher);
    }

    @Override
    public void fireTeacher(String id) {
        teacherRepo.removeTeacher(id);
    }

    @Override
    public Teacher findTeacherById(String id) {
        return teacherRepo.getTeacherById(id);
    }

    @Override
    public List<Teacher> listAllTeachers() {
        return teacherRepo.getAllTeachers();
    }
}

