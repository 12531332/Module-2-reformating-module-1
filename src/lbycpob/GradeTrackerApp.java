package lbycpob

public class GradeTrackerApp {

    private StudentRepository repo = new StudentRepository();
    private StudentInputHandler inputHandler = new StudentInputHandler();
    private IDVerifier idVerifier = new IDVerifier();

    public void main() {
        // [TRACE] Create one app object, then start the menu loop
        displayMenu();
    }

    void displayMenu() {
        String choice;
        do {
            ReportPrinter.printSeparatorLine(); // [TRACE] Static call — no object needed
            IO.println("\t\t\t GRADE TRACKER MENU");
            ReportPrinter.printSeparatorLine();
            IO.println("\t1. Enter Student Data");
            IO.println("\t2. View Report");
            IO.println("\t3. View Class Statistics");
            IO.println("\t4. Verify ID Number");
            IO.println("\t5. Exit");
            ReportPrinter.printSeparatorLine();
            IO.print("Enter choice (1-5): ");

            choice = IO.readln().trim();

            switch (choice) {
                case "1" -> inputStudentData();
                case "2" -> ReportPrinter.printReport(repo);      // [TRACE] Static call
                case "3" -> ReportPrinter.printClassStats(repo);  // [TRACE] Static call
                case "4" -> idVerifier.verifyID();
                case "5" -> IO.println("Goodbye!");
                default -> IO.println("Invalid choice. Please enter 1 to 5.");
            }

        } while (!choice.equals("5"));
    }
}