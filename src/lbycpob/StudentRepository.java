package lbycpob;

public class StudentRepository {

    private Student[] students = new Student[GradeConstants.MAX_STUDENTS];
    private int count = 0;

    public void addStudent(Student s) {
        // [TRACE] count >= MAX_STUDENTS means the array is full
        if (count >= GradeConstants.MAX_STUDENTS) {
            IO.println("Repository is full. Cannot add more students.");
            return;
        }


        // [TRACE] students[count] = s, then count incremented by 1
        students[count++] = s;

    }

    public Student getStudent(int index) {
        if (index < 0 || index >= count) {
            return null;
        }
        return students[index];
    }

    // [RETRIEVE] Returns total number of stored students
    public int getCount() {

        return count;
    }
}

