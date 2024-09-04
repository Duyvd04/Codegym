package MVCDemo.Service;

import MVCDemo.Model.Teacher;
import java.util.List;

public interface InterfaceTeacherService {
    void hireTeacher(Teacher teacher);
    void fireTeacher(String id);
    Teacher findTeacherById(String id);
    List<Teacher> listAllTeachers();
}

