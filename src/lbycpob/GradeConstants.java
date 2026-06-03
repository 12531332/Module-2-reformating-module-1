package lbycpob

public class GradeConstants {

    public static final int    MAX_STUDENTS       = 20;
    public static final double MIN_SCORE          = 0.0;
    public static final double MAX_SCORE          = 100.0;
    public static final int    SEPARATOR          = 50;
    public static final int    NUM_MODULES        = 5;
    public static final int    ID_LENGTH          = 8;
    public static final int    ID_DIVISOR         = 11;
    public static final int    FACULTY_THRESHOLD  = 16;

    // [WEIGHT] Component weights for raw grade computation
    // [TRACE] All five weights must sum to 1.0 (100%)
    //         0.40 + 0.05 + 0.05 + 0.20 + 0.30 = 1.00
    public static final double LAB_WEIGHT           = 0.40;
    public static final double PARTICIPATION_WEIGHT = 0.05;
    public static final double TEACHER_WEIGHT       = 0.05;
    public static final double EXAM_WEIGHT          = 0.20;
    public static final double PROJECT_WEIGHT       = 0.30;
}