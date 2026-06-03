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
