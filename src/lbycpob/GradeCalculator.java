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
