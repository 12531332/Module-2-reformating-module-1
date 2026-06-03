package lbycpob

public class IDVerifier {
    public void verifyID() {
        String continueInput;

        do {
            IO.print("Enter ID: ");
            String idNumber = IO.readln().trim();

            IO.println(validateID(idNumber));

            IO.print("Check another ID? (yes/y to continue): ");
            continueInput = IO.readln().trim().toLowerCase();

        } while (continueInput.equalsIgnoreCase("yes")
                || continueInput.equalsIgnoreCase("y"));

        IO.println("Exiting ID verification.");
    }
}