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
