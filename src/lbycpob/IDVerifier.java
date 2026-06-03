package lbycpob;

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

    public static String getIDRole(String idNumber) {
        int quotient = calculateDotProduct(idNumber)/GradeConstants.ID_DIVISOR;
        return quotient >= GradeConstants.FACULTY_THRESHOLD ? "faculty" : "student";
    }

    public static String validateID(String idNumber) {
        if (idNumber == null)
            return "Invalid ID number. Please enter " + GradeConstants.ID_LENGTH + " characters.";
        if (idNumber.length() != GradeConstants.ID_LENGTH)
            return "Invalid ID number. Please enter " + GradeConstants.ID_LENGTH + " characters.";

        // [VALIDATE] Digit check — specific message for non-digit input
        for (char c : idNumber.toCharArray())
            if (!Character.isDigit(c))
                return "Invalid ID number. All characters must be digits.";

        if (!isValidID(idNumber))
            return "Invalid ID number. Dot product must be divisible by " + GradeConstants.ID_DIVISOR + ".";

        // [TRACE] All checks passed — delegate role decision to getIDRole()
        return "Valid " + getIDRole(idNumber) + " ID number.";
    }

    private static int calculateDotProduct(String idNumber) {
        int sum = 0;
        int weight = GradeConstants.ID_LENGTH;
        for (char c : idNumber.toCharArray()) {
            sum += Character.getNumericValue(c) * weight;
            weight--;
        }

        return sum;
    }
}