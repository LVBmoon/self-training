package y_2025.m_05.week_1;

import java.util.Arrays;

public class ex02_interface_sorting_students {
    public static void main(String[] args) {
        Student[] students = {
                new Student("Elizabet", "Swan", 403493985),
                new Student("LVB", "Moon", 403888888),
                new Student("Dervish", "Gradey", 111000111),
                new Student("Cedric", "Digory", 405005520),
                new Student("LVB", "Moon", 403888888),
                new Student("R", "LStain", 400527151),
                new Student("Dervish", "Gradey", 111000111)
        };

        Student[] unique = new Student[students.length];
        int count = 0;

        for (int i = 0; i < students.length; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < count; j++) {
                if (students[i].getStudentID() == unique[j].getStudentID()) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                unique[count] = students[i];
                count++;
            }
        }

        Student[] sorted = new Student[count];
        System.arraycopy(unique, 0, sorted, 0, count);
        Arrays.sort(sorted);

        printList(sorted);
    }

    public static void printList(Student[] sorted) {
        for (Student s : sorted) {
            System.out.println(s);
        }
    }

    interface Person {
        String getName();
    }

    static class Student implements Person, Comparable<Student> {
        private final String firstName;
        private final String lastName;
        private final int studentID;

        public Student(String firstName, String lastName, int studentID) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.studentID = studentID;
        }

        @Override
        public String getName() {
            return "First Name: " + firstName + " Last Name: " + lastName;
        }

        public int getStudentID() {
            return studentID;
        }

        @Override
        public int compareTo(Student other) {
            int lastCmp = this.lastName.compareToIgnoreCase(other.lastName);
            if (lastCmp != 0) {
                return lastCmp;
            }
            return this.firstName.compareToIgnoreCase(other.firstName);
        }

        @Override
        public String toString() {
            return "Student ID: " + studentID + " | First Name: " + firstName + " ,  Last Name: " + lastName ;
        }
    }
}
