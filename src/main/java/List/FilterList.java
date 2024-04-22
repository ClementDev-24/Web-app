package List;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterList {
    static class Student{
        private String StudentName;
        private int mark;

        public String getStudentName() {
            return StudentName;
        }

        public void setStudentName(String studentName) {
            StudentName = studentName;
        }

        public int getMark() {
            return mark;
        }

        public void setMark(int mark) {
            this.mark = mark;
        }

        public String getTeacherName() {
            return teacherName;
        }

        public Student(String studentName, int mark, String teacherName) {
            StudentName = studentName;
            this.mark = mark;
            this.teacherName = teacherName;
        }

        public void setTeacherName(String teacherName) {
            this.teacherName = teacherName;
        }

        private String teacherName;
        @Override
        public String toString() {
            return "Student{" +
                    "studentName='" + StudentName + '\'' +
                    ", mark=" + mark +
                    ", teacherName='" + teacherName + '\'' +
                    '}';
        }
    }
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<Student>();

        studentList.add(new Student("alemet",403,"hello"));
        studentList.add(new Student("alemet",401,"hello"));
        studentList.add(new Student("alemet",1,"hello"));

        java.util.Set<String> collect = studentList.stream().filter(student -> student.getMark() > 400 && student.getStudentName().startsWith("a")).map(Student::getTeacherName).collect(Collectors.toSet());
        studentList.stream().map(Student::getMark).filter(mark -> mark > 400).collect(Collectors.toList());
        System.out.println(collect);
        Student set = studentList.set(1, new Student("alemet", 403, "hello"));
        set = studentList.set(2,new Student("alemet",401,"hello"));
        System.out.println(set);
    }
}
