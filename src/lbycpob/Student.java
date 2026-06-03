package lbycpob;

public class Student {
    private String name;
    private String idNumber;
    private double rawGrade;
    private String numericGrade;
    private char letterRank;

    public Student() {
    }

    public Student(String name, String idNumber, double rawGrade, String numericGrade, char letterRank) {
        setName(name);
        setIdNumber(idNumber);
        setRawGrade(rawGrade);
        setNumericGrade(numericGrade);
        setLetterRank(letterRank);
    }

    public void setLetterRank(char letterRank) {
        String valid = "SABCDEFPFsabcdefpf";
        if (valid.indexOf(letterRank) >= 0)
            this.letterRank = Character.toUpperCase(letterRank);
        else
            IO.println("Error: invalid letter rank " + letterRank + ".");
    }

    public void setNumericGrade(String numericGrade) {
        if (numericGrade == null || numericGrade.isBlank()) {
            IO.println("Error: invalid numeric grade cannot be null or blank.");
            return;
        }
        this.numericGrade = numericGrade.trim();
    }
}