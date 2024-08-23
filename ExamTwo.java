/*
 * Written collectively by Ryan Harding, Kenneth Le, Majd Mohammad
 * Submitted on 11/19/2023
 * GROUP A EXAM 2 PROJECT
 */
import java.util.ArrayList;

public class ExamTwo {

    public static void main(String[] args) {

        ArrayList<Student>studentList = new ArrayList<>();
        
        boolean quit = false;
        while(!quit) {
            int choice = Methods.getMenuChoice();
            switch (choice) {
                case 1: //Create Student
                    Student newStudent = Methods.createAStudent();
                    studentList.add(newStudent);
                    break;
                case 2: //Display Students
                    if (studentList.size() > 0) {
                        for (int i = 0; i < studentList.size(); i++) {
                            Student student = studentList.get(i);
                            System.out.println((i + 1) + ". " + student);
                        }//end i loop
                    } else {
                        System.out.println("No students have been created.");
                    }
                    break; 
                case 3: //Quit 
                    System.out.println("Quitting the program");
                    quit = true;
                    break;
                default:
                    System.out.println("Error: Please enter a valid choice");
            } // end switch 
            
        } // end while
        
    } // end main 

} // end class