package lbycpob;

public class ReportPrinter {

    public static void printSeparatorLine() {
        IO.println("=".repeat(GradeConstants.SEPARATOR));
    }

    public static void printReport(StudentRepository repo) {
        // [VALIDATE] Guard: no data to display
        if (repo.getCount() == 0) {
            IO.println("No data to display. Please enter student data first.");
            return;
        }

        StringBuilder sb = new StringBuilder();

        final int TABLE_WIDTH = 80;

        sb.append("\n");
        sb.repeat("=", TABLE_WIDTH).append("\n");

        sb.append(String.format(
                "%-5s %-10s %-20s %-10s %-7s %-6s %-5s%n",
                "No.", "ID", "Name", "Raw Ave.", "Grade", "Rank", "Remarks"));

        sb.repeat("-", TABLE_WIDTH).append("\n");

        for (int i = 0; i < repo.getCount(); i++) {
            Student s     = repo.getStudent(i);
//            String  grade = s.getNumericGrade();
//            char    rank  = s.getLetterRank();

        }

        // [FORMAT] Build table footer
        sb.repeat("=", TABLE_WIDTH).append("\n");

        IO.print(sb.toString());
    }

    public static void printClassStats(StudentRepository repo) {
        if (repo.getCount() == 0) {
            IO.println("\n[TRACE] studentCount = 0 - No data to process");
            IO.println("Cannot compute statistics. Please enter student data first.");
            return;
        }

        IO.println("\n[TRACE] Processing " + repo.getCount() + " student records...");

        int    highestIndex = 0;
        int    lowestIndex  = 0;

        printSeparatorLine(); // [TRACE] Static call to sibling static method
        IO.println("           CLASS STATISTICS REPORT          ");
        printSeparatorLine();
        IO.println(String.format("  Total Students:     %d%n", repo.getCount()));
        IO.println("-".repeat(GradeConstants.SEPARATOR));

    }
}