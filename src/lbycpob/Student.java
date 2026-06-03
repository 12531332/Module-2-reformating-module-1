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


}