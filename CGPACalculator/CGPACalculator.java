package CGPACalculator;
import java.util.Scanner;

public class CGPACalculator {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        //Prompt Username and Display
        //User Greetings
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
       
        
        //Input validation for number of subjects 
        int numSubjects = 0;
        while (numSubjects <= 0){
            System.out.print("Enter the number of subjects: ");
            String input = scanner.nextLine();
            
            if (input.trim().isEmpty()){
                System.out.println("Required Input: You must enter a number to proceed.");
                continue;
            }
            
            try{
                numSubjects = Integer.parseInt(input); //Conversion from String input to Integer 
                if (numSubjects <= 0){
                    System.out.println("Error: Please enter a positive number.");
                }
            } catch(NumberFormatException e) {
                System.out.println("Error: Invalid Input. Please enter a whole number.");
            }
        }

        //Create a "Student" object and pass name and number of subjects 
        Student student = new Student(name, numSubjects);

        //Grade point mapping
        double [] gradePoints = {4.0 ,3.75 ,3.5 ,3.0 ,2.5 ,2.0 ,1.0 ,0.0};
        String [] gradeLetters = {"A+","A","B+","B","C+","C","D","F"};

        //Loop to get subject name,grades and credit hours with validation 
        for (int i = 1; i <= numSubjects; i++){
            //Validation Subject name
            String subjectName = "";
            boolean validSubject = false;
            while (!validSubject){
                System.out.print("Enter the name of subject " + i + ": ");
                subjectName = scanner.nextLine();
                
                // Fixed logic to ensure the subject name is not empty
                if (!subjectName.trim().isEmpty()){
                    validSubject = true;
                } else {
                    System.out.println("Error: Invalid subject name. Please enter a valid name.");
                }
            }

            //Validation Subject Grades
            String grade = ""; 
            boolean validGrade = false;
            while (!validGrade){
                System.out.print("Enter grade for subject " + subjectName + " { A+ ,A ,B+ ,B ,C+ ,C ,D ,F }: ");
                grade = scanner.nextLine();
                
                for (String validGradeLetter : gradeLetters){
                    if (grade.equalsIgnoreCase(validGradeLetter)){
                        validGrade = true;
                        break;
                    }
                } 
                if (!validGrade){
                    System.out.println("Error: Invalid grade. Please enter a valid grade.");
                }
            }

            //Validation Credit Hours 
            int creditHours = 0; //default value
            while (creditHours <= 0){
                System.out.print("Enter the credit hours for subject " + subjectName + " : ");
                String input = scanner.nextLine();
                
                if (input.trim().isEmpty()){
                    System.out.println("Required Input: You must enter credit hours to proceed.");
                    continue;
                }
                
                //Conversion
                try{
                    creditHours = Integer.parseInt(input);
                    if (creditHours <= 0){
                        System.out.println("Error: Credit hours must be a positive integer.");
                    }
                } catch(NumberFormatException e) {
                    System.out.println("Error: Invalid Input. Please enter a valid input for credit hours.");
                }
            }

            //Final corresponding grade point
            double gradePoint = 0.0;
            for (int j = 0; j < gradeLetters.length; j++){
                if (grade.equalsIgnoreCase(gradeLetters[j])){
                    gradePoint = gradePoints[j];
                    break;
                }
            }
            
            //add grade point, credit hours and subject name to the student object 
            student.addGradePoints(gradePoint, creditHours, grade, subjectName);
        }

        // Print all input data and CGPA 
        student.printDetails();
        
        // Close the scanner to prevent resource leaks
        scanner.close();
    }
}