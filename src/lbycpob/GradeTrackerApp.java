package lbycpob

public class GradeTrackerApp {

    private StudentRepository repo = new StudentRepository();
    private StudentInputHandler inputHandler = new StudentInputHandler();
    private IDVerifier idVerifier = new IDVerifier();

    public void main() {
        // [TRACE] Create one app object, then start the menu loop
        displayMenu();
    }


}