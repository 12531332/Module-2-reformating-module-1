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

    public void setRawGrade(double rawGrade) {
        if (rawGrade < GradeConstants.MIN_SCORE || rawGrade > GradeConstants.MAX_SCORE)
            IO.println("Error: Raw grade must be between " + GradeConstants.MIN_SCORE + " and " + GradeConstants.MAX_SCORE + ".");

        else
            this.rawGrade = rawGrade;
    }

    public void setName(String name) {
        if  (name == null || name.isBlank())
            IO.println("Error: name cannot be null or blank.");
        else
            this.name = name.trim();
    }

    public void setIdNumber(String idNumber) {
        if (idNumber == null || idNumber.isBlank()){
            IO.println("Error: id number cannot be null or blank.");
            return;
        }
        this.idNumber = idNumber.trim();
    }

    public String getName() {
        return name;
    }
    public String getIdNumber() {
        return idNumber;
    }
    public double getRawGrade() {
        return rawGrade;
    }
    public String getNumericGrade() {
        return numericGrade;
    }
    public char getLetterRank() {
        return letterRank;
    }

}