package lbycpob

public static double computeAverage(double[] scores) {

    if (scores == null || scores.length == 0)
        return 0.0;

    double sum = 0.0;
    for (double score : scores) {
        sum += score;
    }
    return sum / scores.length;
}
