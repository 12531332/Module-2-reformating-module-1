package lbycpob;

public class StudentInputHandler {

    public String inputName(int studentNumber) {
        String name;
        do {
            IO.print("Student " + studentNumber + " name: ");
            name = IO.readln().trim();
            if (name.isEmpty()) IO.println("Name cannot be blank. Try again.");
        } while (name.isEmpty());
        return name;
    }

    public int inputStudentCount() {
        int count;
        do {
            IO.print("How many students? (1-" + GradeConstants.MAX_STUDENTS + "): ");
            count = Integer.parseInt(IO.readln().trim());
            if (count < 1 || count > GradeConstants.MAX_STUDENTS)
                IO.println("Please enter a number between 1 and "
                        + GradeConstants.MAX_STUDENTS + ".");
        } while (count < 1 || count > GradeConstants.MAX_STUDENTS);
        return count;
    }

    public double inputComponentScore(String prompt) {
        double score;
        do {
            IO.print(prompt);
            score = Double.parseDouble(IO.readln().trim());
            if (score < GradeConstants.MIN_SCORE || score > GradeConstants.MAX_SCORE)
                IO.println("  Score must be between "
                        + GradeConstants.MIN_SCORE + " and "
                        + GradeConstants.MAX_SCORE + ".");
        } while (score < GradeConstants.MIN_SCORE || score > GradeConstants.MAX_SCORE);
        return score;
    }

    public double inputLabPerformance() {
        double[] moduleScores = new double[GradeConstants.NUM_MODULES];

        IO.println("  --- Laboratory Performance (40% of grade) ---");

        for (int module = 0; module < GradeConstants.NUM_MODULES; module++) {
            moduleScores[module] = inputComponentScore(
                    "    Module " + (module + 1) + " score: ");
        }

        double labAverage = GradeCalculator.computeAverage(moduleScores);
        IO.println("    Laboratory Performance Average: "
                + String.format("%.2f", labAverage));
        return labAverage;
    }

    public Student inputOneStudent(int studentNumber) {
        String name     = inputName(studentNumber);

        String idNumber = inputIdNumber(studentNumber);

        IO.println("  --- Entering grades for " + name + " ---");

        double labPerformance     = inputLabPerformance();

        double classParticipation = inputComponentScore(
                "  Class Participation (averaged): ");

        double teacherEvaluation  = inputComponentScore(
                "  Teacher's Evaluation (averaged): ");

        double practicalExam      = inputComponentScore(
                "  Practical Exam: ");

        double project            = inputComponentScore(
                "  Project: ");

        double rawGrade     = GradeCalculator.computeRawGrade(
                labPerformance, classParticipation,
                teacherEvaluation, practicalExam, project);
        String numericGrade = GradeCalculator.assignNumericGrade(rawGrade);
        char   letterRank   = GradeCalculator.assignLetterRank(rawGrade);

        IO.println("  " + name + "'s final raw score: "
                + String.format("%.2f", rawGrade));

        return null; // placeholder
    }

    public String inputIdNumber(int studentNumber) {
        String idNumber;
        String validationResult;

        do {
            IO.print("Student " + studentNumber + " ID number ("
                    + GradeConstants.ID_LENGTH + " digits): ");
            idNumber = IO.readln().trim();

            // [TRACE] Static call — IDVerifier.validateID(idNumber)
            //         Returns a descriptive result message string.
            validationResult = IDVerifier.validateID(idNumber);

            if (validationResult.startsWith("Invalid")) {
                // [TRACE] Print the specific reason the ID was rejected
                IO.println("  " + validationResult + " Please try again.");
            } else {
                // [TRACE] Print confirmation so the user knows it was accepted
                IO.println("  " + validationResult);
            }

        } while (validationResult.startsWith("Invalid"));

        return idNumber;
    }
}