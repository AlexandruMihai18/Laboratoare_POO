package lab4.people;

import lab4.database.Database;

import java.util.*;
import java.util.stream.Collectors;

public class Student {
    private String firstName;
    private String lastName;
    private Map<String, Integer> subjects;

    public Student(String firstName, String lastName, Map<String, Integer> subjects) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subjects = subjects;
    }

    // copy constructor
    public Student(Student student) {
        this.firstName = new String(student.firstName);
        this.lastName = new String(student.lastName);
        this.subjects = new HashMap<>(student.subjects);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Map<String, Integer> getSubjects() {
        return subjects;
    }

    public void setSubjects(HashMap<String, Integer> subjects) {
        this.subjects = subjects;
    }

    public double averageGrade() {
        int gradeSum = 0;
        for (Map.Entry<String, Integer> entry : subjects.entrySet()) {
            gradeSum += entry.getValue();
        }

        return gradeSum / subjects.size();
    }

    public List<Teacher> getAllTeachers() {
        // TODO
        List<Teacher> teachers = Collections.unmodifiableList(Database.getDatabase().findAllTeachers());

        return teachers;
    }

    public int getGradeForSubject(String subject) {
        return subjects.get(subject).intValue();
    }

    @Override
    public String toString() {
        return "Student: " + firstName + " " + lastName + "\n"
                + "Subjects: " + subjects + "\n";
    }

    public List<Teacher> getTeachersBySubject(String subject) {
        List<Teacher> teachers = Collections.unmodifiableList(Database.getDatabase().findTeachersBySubject(subject));

        return teachers;
    }

    public List<Student> getAllStudents() {
        List<Student> students = Collections.unmodifiableList(Database.getDatabase().findAllStudents());

        return students;
    }

    public List<Student> getStudentsBySubject(String subject) {
        List<Student> students = Collections.unmodifiableList(Database.getDatabase().getStudentsBySubject(subject));

        return students;
    }

    public List<Student> getStudentsByAverageGrade() {
        List<Student> students = Collections.unmodifiableList(Database.getDatabase().getStudentsByAverageGrade());

        return students;
    }

    public List<Student> getStudentsByGradeForSubject(String subject) {
        List<Student> students = Collections.unmodifiableList(Database.getDatabase().getStudentsByGradeForSubject(subject));

        return students;
    }
}