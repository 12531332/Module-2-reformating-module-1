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

    public static boolean isValidID(String idNumber) {
        if (idNumber == null) return false;
        if (idNumber.length() != GradeConstants.ID_LENGTH) return false;

        for (char c : idNumber.toCharArray())
            if (!Character.isDigit(c)) return false;

        return calculateDotProduct(idNumber) % GradeConstants.ID_DIVISOR==0;
        // [TRACE] calculateDotProduct(idNumber) % 11 == 0 → valid
    }
}