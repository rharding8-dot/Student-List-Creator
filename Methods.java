import java.util.Scanner;

public class Methods {

    private static Scanner scanner = new Scanner(System.in);

    public static int getMenuChoice() {
        StringBuilder menu = new StringBuilder();
        menu.append("[1] Create a student\n");
        menu.append("[2] Display all students\n");
        menu.append("[3] Quit\n");
        menu.append("Enter your selection >> ");

        int choice = 0;
        boolean validChoice = false;
        do {
            try {
                System.out.println(menu.toString());
                String input = scanner.nextLine();
                choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= 3) {
                    validChoice = true;
                } else {
                    System.out.println("\nInvalid choice. Please enter from the listed choices.\n");
                }//exception handling
            } catch (NumberFormatException nfe) {
                System.out.println("\nYou have entered an invalid option. Please choice from the menu.\n");
            }//exception handling
        } while (!validChoice);

        return choice;
    }//end getMenuChoice method
    

    public static Student createAStudent() {
        String fName = null, middleInitial = null, lName = null;

        while (fName == null) {
            try {
                fName = getValidString("Enter first name: ", false);
                new Name(fName, "A", "Dummy"); // Temporary check for first name
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Please try again.");
                fName = null;
            }//exception handling
            
        }//end fName while loop
    
        while (middleInitial == null) {
            try {
                middleInitial = getValidString("Enter the middle initial (or press enter for none): ", true);
                new Name("Dummy", middleInitial, "Dummy"); // Temporary check for middle initial
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Please try again.");
                middleInitial = null;
            }//exception handling
            
        }//end middleInitial while loop
    
        while (lName == null) {
            try {
                lName = getValidString("Enter last name: ", false);
                new Name("Dummy", "A", lName); // Temporary check for last name
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Please try again.");
                lName = null;
            }//exception handling
            
        }//end lName while loop

        Name name = new Name(fName, middleInitial, lName);
    
        Date dateOfBirth = null;
        while (dateOfBirth == null) {
            try {
                int month = getValidNumber("Month (1-12): ", 1, 12);
                int day = getValidNumber("Day: ", 1, 31); // General range, actual validation in Date class
                int year = getValidNumber("Year: ", 1, Integer.MAX_VALUE);

                dateOfBirth = new Date(month, day, year);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage() + " Please enter a valid date.");
            }//exception handling
            
        }//end dateOfBirth while loop

        boolean validGpa = false;
        float gpa = 0.0f;
        while (!validGpa) {
            System.out.print("Enter student's GPA (0.0 - 5.0): ");
            String input = scanner.nextLine(); // Read the entire line as a String
            try {
                gpa = Float.parseFloat(input); // Try to convert the string to a float
                if (gpa >= 0.0 && gpa <= 5.0) {
                    validGpa = true;
                } else {
                    System.out.println("Invalid GPA. Please enter a value between 0.0 and 5.0.");
                }//exception handling
            } catch (NumberFormatException ime) {
                System.out.println("Invalid input. Please enter a numeric value.");
            }//exception handling
            
        }//end !validGpa while loop
        
        
        boolean validCredits = false;
        int creditsTaken = 0;
        while(!validCredits) {
            System.out.print("Enter the student's credits (0 - 200): ");
            String input = scanner.nextLine(); // Read the entire line as a String
            try {
                creditsTaken = Integer.parseInt(input); // Try to convert the string to an integer
                if(creditsTaken >= 0 && creditsTaken <= 200) {
                    validCredits = true;
                } else {
                    System.out.println("Invalid credits. Please enter a value between 0 and 200.");
                }//exception handling
            } catch (NumberFormatException ime) {
                System.out.println("Invalid input. Please enter a numeric value.");
            }//exception handling
            
        }//end !validCredits while loop
        
        
        
        System.out.println("\n === Student has been created === \n");
        return new Student(name, dateOfBirth, gpa, creditsTaken);
        
    }//end createAStudent method
    

    private static int getValidNumber(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("reset")) {
                throw new IllegalArgumentException("reset");
            }//exception handling

            try {
                int number = Integer.parseInt(input);
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.out.println("Please enter a valid number.");
                }//exception handling
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }//exception handling
            
        }//end while loop
        
    }//end getValidNumber method
    

    public static String getValidString(String prompt, boolean allowEmpty) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (input.trim().isEmpty()) {
                if (allowEmpty) {
                    return "";
                } else {
                    System.out.println("Input cannot be empty.");
                }//exception handling
            } else {
                return input;
            }//end if-else
            
        }//end while loop
        
    }//end getValidString method
    
}//end Methods class