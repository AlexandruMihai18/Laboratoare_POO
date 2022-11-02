package lab4.database;

import lab4.people.Student;
import lab4.people.Teacher;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Database {
    private final List<Student> students = new ArrayList<>();
    private final List<Teacher> teachers = new ArrayList<>();
    private static int instanceCount = 0;

    private static Database database = null;

    private Database() {
        instanceCount++;
    }

    public static Database getDatabase() {
        if (database == null) {
            database = new Database();
        }
        return database;
    }

    public static int getNumberOfInstances() {
        return instanceCount;
    }

    public void addTeachers(List<Teacher> teachers) {
        this.teachers.addAll(teachers);
    }

    public void addStudents(List<Student> students) {
        this.students.addAll(students);
    }

    public List<Teacher> findTeachersBySubject(String subject) {
        List<Teacher> teachersList = new ArrayList<>();
        boolean found;

        for (int i = 0; i < teachers.size(); i++) {
            found = false;
            for (int j = 0; j < teachers.get(i).getSubjects().size() && found == false; j++) {
                if (teachers.get(i).getSubjects().get(j).equals(subject)) {
                    teachersList.add(teachers.get(i));
                    found = true;
                }
            }
        }

        return teachersList;
    }

    public List<Student> findAllStudents() {
        return students;
    }

    public List<Teacher> findAllTeachers() {
        return teachers;
    }

    public List<Student> getStudentsBySubject(String subject) {
        List<Student> studentList = new ArrayList<>();

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getSubjects().get(subject) != null) {
                studentList.add(students.get(i));
            }
        }

        return studentList;
    }

    public List<Student> getStudentsByAverageGrade() {
        List<Student> studentList = new ArrayList<>();
        for (Student student: students) {
            studentList.add(new Student(student));
        }
        studentList.sort(new Comparator<Student>() {
            @Override
                public int compare(Student student1, Student student2) {
                    if (student1.averageGrade() > student2.averageGrade())
                        return 1;
                    if (student1.averageGrade() < student2.averageGrade())
                        return -1;
                    return 0;
            }
        });
        return studentList;
    }

    public List<Student> getStudentsByGradeForSubject(String subject) {
        List<Student> studentList = getStudentsBySubject(subject);
        studentList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                if (student1.getGradeForSubject(subject) > student2.getGradeForSubject(subject))
                    return 1;
                if (student1.getGradeForSubject(subject) < student2.getGradeForSubject(subject))
                    return -1;
                return 0;
            }
        });
        return studentList;
    }
}