package MVCDemo.Repository;


import MVCDemo.Model.Teacher;
import java.util.List;

public interface InterfaceTeacherRepo {
    void addTeacher(Teacher teacher);
    void removeTeacher(String id);
    Teacher getTeacherById(String id);
    List<Teacher> getAllTeachers();
}

