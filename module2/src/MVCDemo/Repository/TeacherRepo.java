package MVCDemo.Repository;

import MVCDemo.Model.Teacher;
import java.util.ArrayList;
import java.util.List;

public class TeacherRepo implements InterfaceTeacherRepo {
    private List<Teacher> teachers = new ArrayList<>();

    @Override
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    @Override
    public void removeTeacher(String id) {
        teachers.removeIf(teacher -> teacher.getId().equals(id));
    }

    @Override
    public Teacher getTeacherById(String id) {
        return teachers.stream().filter(teacher -> teacher.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teachers;
    }
}

