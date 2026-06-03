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

