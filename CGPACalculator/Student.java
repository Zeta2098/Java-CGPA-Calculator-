package CGPACalculator;
 import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Student {


    //Private Encapsulation field 
    private String name;
    private int numSubjects;
    private List<String> subjectName;
    private final List<String> grades;
    private final List<Integer> creditHours;
    private double totalGradePoints;
    private int totalCreditHours;

    //Constructor to initialize the student's data
    public Student(String name, int numSubjects){
        this.name = name;
        this.numSubjects = numSubjects;
        this.subjectName = new ArrayList<>();
        this.totalGradePoints = 0.0;
        this.totalCreditHours = 0;
        this.grades = new ArrayList<>();
        this.creditHours = new ArrayList<>();
    }

    //Setter for name and subject name
    public void setName(String name){
        this.name = name;
    }
    public void setSubjectName(String subjectName){
        this.subjectName.add(subjectName);
    }

    //Getter for name and number of subjects 
    public String getName(){
        return name;
    }
    public int getNumSubject(){
        return numSubjects;
    }

    //Methods add subject grade points , credit hours and name of the subject and add storing the input 
    public void addGradePoints(double gradePoints, int creditHours, String grade, String subjectName){
        this.totalGradePoints += gradePoints * creditHours;
        this.totalCreditHours += creditHours;
        this.subjectName.add(subjectName);
        this.grades.add(grade);
        this.creditHours.add(creditHours); 
    }

    //Calc CGPA
    public double calculateCGPA(){
        if (totalCreditHours == 0){
            return 0.0;
        }
        double cgpa = totalGradePoints / totalCreditHours;
        DecimalFormat df = new DecimalFormat("#.####");
        return Double.parseDouble(df.format(cgpa));
    }

    //Methods to print all entered input data to the console
    public void printDetails(){
        StringBuilder report = new StringBuilder();

        report.append("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");
        report.append("Student Name: ").append(name).append("\n");
        report.append("Number of Subjects: ").append(numSubjects).append("\n");
        report.append("Details of Grades and Credit Hours:\n");

        for (int i = 0; i < grades.size(); i++) {
            report.append("Subject ").append(subjectName.get(i))
                  .append(": Grade = ").append(grades.get(i))
                  .append(", Credit Hours = ").append(creditHours.get(i)).append("\n");
        }

        report.append("Total Credit Hours: ").append(totalCreditHours).append("\n");
        report.append("CGPA: ").append(calculateCGPA()).append("\n");
        report.append("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");

        // Display the result in console
        System.out.println(report.toString());
    }
}

