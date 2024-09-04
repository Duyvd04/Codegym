package MVCDemo.View;

import MVCDemo.Controller.StudentController;
import MVCDemo.Controller.TeacherController;
import MVCDemo.Model.Student;
import MVCDemo.Model.Teacher;
import MVCDemo.Repository.StudentRepo;
import MVCDemo.Repository.TeacherRepo;
import MVCDemo.Service.StudentService;
import MVCDemo.Service.TeacherService;

import java.util.List;
import java.util.Scanner;

public class ManagementTest {
    public static void main(String[] args) {
        StudentRepo studentRepo = new StudentRepo();
        StudentService studentService = new StudentService(studentRepo);
        StudentController studentController = new StudentController(studentService);

        TeacherRepo teacherRepo = new TeacherRepo();
        TeacherService teacherService = new TeacherService(teacherRepo);
        TeacherController teacherController = new TeacherController(teacherService);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Xem thông tin học sinh");
            System.out.println("2. Xem thông tin giáo viên");
            System.out.println("3. Thêm học sinh");
            System.out.println("4. Thêm giáo viên");
            System.out.println("5. Xóa học sinh");
            System.out.println("6. Xóa giáo viên");
            System.out.println("7. Thoát chương trình");
            System.out.print("Chọn một tùy chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    List<Student> students = studentController.getAllStudents();
                    if (students.isEmpty()) {
                        System.out.println("Không có học sinh nào.");
                    } else {
                        System.out.println("Danh sách học sinh:");
                        for (Student student : students) {
                            System.out.println("ID: " + student.getId() + ", Tên: " + student.getName() + ", Tuổi: " + student.getAge() + ", Lớp: " + student.getStudentClass());
                        }
                    }
                    break;

                case 2:
                    List<Teacher> teachers = teacherController.getAllTeachers();
                    if (teachers.isEmpty()) {
                        System.out.println("Không có giáo viên nào.");
                    } else {
                        System.out.println("Danh sách giáo viên:");
                        for (Teacher teacher : teachers) {
                            System.out.println("ID: " + teacher.getId() + ", Tên: " + teacher.getName() + ", Tuổi: " + teacher.getAge() + ", Môn dạy: " + teacher.getSubject());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Nhập ID học sinh: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Nhập tên học sinh: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Nhập tuổi học sinh: ");
                    int studentAge = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập lớp học sinh: ");
                    String studentClass = scanner.nextLine();

                    studentController.addStudent(studentId, studentName, studentAge, studentClass);
                    System.out.println("Thêm học sinh thành công!");
                    break;

                case 4:
                    System.out.print("Nhập ID giáo viên: ");
                    String teacherId = scanner.nextLine();
                    System.out.print("Nhập tên giáo viên: ");
                    String teacherName = scanner.nextLine();
                    System.out.print("Nhập tuổi giáo viên: ");
                    int teacherAge = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập môn dạy giáo viên: ");
                    String teacherSubject = scanner.nextLine();

                    teacherController.addTeacher(teacherId, teacherName, teacherAge, teacherSubject);
                    System.out.println("Thêm giáo viên thành công!");
                    break;

                case 5:
                    System.out.print("Nhập ID học sinh cần xóa: ");
                    String removeStudentId = scanner.nextLine();
                    studentController.removeStudent(removeStudentId);
                    System.out.println("Xóa học sinh thành công!");
                    break;

                case 6:

                    System.out.print("Nhập ID giáo viên cần xóa: ");
                    String removeTeacherId = scanner.nextLine();
                    teacherController.removeTeacher(removeTeacherId);
                    System.out.println("Xóa giáo viên thành công!");
                    break;

                case 7:
                    System.out.println("Đang thoát chương trình...");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 7);

        scanner.close();
    }
}
