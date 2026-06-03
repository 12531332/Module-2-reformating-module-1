package lbycpob

public class GradeCalculator {

    public static double computeAverage(double[] scores) {

        if (scores == null || scores.length == 0)
            return 0.0;

        double sum = 0.0;
        for (double score : scores) {
            sum += score;
        }
        return sum / scores.length;
    }

    public static double computeRawGrade(double labPerformance,
                                         double classParticipation,
                                         double teacherEvaluation,
                                         double practicalExam,
                                         double project) {

        double raw = (labPerformance * GradeConstants.LAB_WEIGHT + classParticipation * GradeConstants.PARTICIPATION_WEIGHT + teacherEvaluation * GradeConstants.TEACHER_WEIGHT + practicalExam * GradeConstants.EXAM_WEIGHT + project * GradeConstants.PROJECT_WEIGHT);
        return (double) Math.round(raw * 100.0) /100;

    }

    public static String assignNumericGrade(double avg) {
        if (avg >= 96.0) return "4.0";
        else if (avg >= 92.0) return "3.5";
        else if (avg >= 88.0) return "3.0";
        else if (avg >= 83.0) return "2.5";
        else if (avg >= 78.0) return "2.0";
        else if (avg >= 74.0) return "1.5";
        else if (avg >= 70.0) return "1.0";
        else return "0.0";
    }

    public static char assignLetterRank(double avg) {
        if (avg >= 96.0) return 'S';
        else if (avg >= 92.0) return 'A';
        else if (avg >= 88.0) return 'B';
        else if (avg >= 83.0) return 'C';
        else if (avg >= 78.0) return 'D';
        else if (avg >= 74.0) return 'E';
        else if (avg >= 70.0) return 'P';
        else return 'F';

    }

    public static String getRemarks(String grade) {
        if (grade == null) return "Unknown";
        return switch (grade.trim()){
            case "4.0" -> "Excellent";
            case "3.5" -> "Superior";
            case "3.0" -> "Very Good";
            case "2.5" -> "Good";
            case "2.0" -> "Satisfactory";
            case "1.5" -> "Fair";
            case "1.0" -> "Poor/Passed";
            case "0.0" -> "Failed";
            default -> "Unknown";
        };
    }

    public static String getRemarks(char rank) {
        return switch (Character.toUpperCase(rank)){
            case 'S' -> "Excellent";
            case 'A' -> "Superior";
            case 'B' -> "Very Good";
            case 'C' -> "Good";
            case 'D' -> "Satisfactory";
            case 'E' -> "Fair";
            case 'P' -> "Poor/Passed";
            case 'F' -> "Failed";
            default -> "Unknown";
        };
    }
}
