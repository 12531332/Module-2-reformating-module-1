package lbycpob;

public class StudentInputHandler {

    public String inputName(int studentNumber) {
        String name;
        do {
            IO.print("Student " + studentNumber + " name: ");
            name = IO.readln().trim();
            if (name.isEmpty()) IO.println("Name cannot be blank. Try again.");
        } while (name.isEmpty());
        return name;
    }

    public int inputStudentCount() {
        int count;
        do {
            IO.print("How many students? (1-" + GradeConstants.MAX_STUDENTS + "): ");
            count = Integer.parseInt(IO.readln().trim());
            if (count < 1 || count > GradeConstants.MAX_STUDENTS)
                IO.println("Please enter a number between 1 and "
                        + GradeConstants.MAX_STUDENTS + ".");
        } while (count < 1 || count > GradeConstants.MAX_STUDENTS);
        return count;
    }