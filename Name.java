public class Name {
    private String fName;
    private String middleInitial;
    private String lName;

    public Name(String fName, String middleInitial, String lName) {
        setFName(fName);
        setMiddleInitial(middleInitial);
        setLName(lName);
    }//end Name constructor with fields

    public void setFName(String fName) {
        if (fName == null || fName.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: the first name cannot be empty or null.");
        }//exception handling
        for (int i = 0; i < fName.length(); i++) {
            if (Character.isDigit(fName.charAt(i))) {
                throw new IllegalArgumentException("Error: First name cannot contain numbers.");
            }//exception handling
        }//end i loop
        this.fName = fName.substring(0, 1).toUpperCase() + fName.substring(1).toLowerCase();
    }//end set fName

    public void setMiddleInitial(String middleInitial) {
        if (middleInitial != null && middleInitial.length() == 1 && Character.isLetter(middleInitial.charAt(0))) {
            this.middleInitial = middleInitial.toUpperCase();
        } else if (middleInitial != null && !middleInitial.isEmpty()) {
            throw new IllegalArgumentException("Error: Middle initial must be a single alphabetic character.");
        }//exception handling
        this.middleInitial = middleInitial;
    }//end set middleInitial

    public void setLName(String lName) {
        if (lName == null || lName.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: the last name cannot be empty or null.");
        }//exception handling
        for (int i = 0; i < lName.length(); i++) {
            if (Character.isDigit(lName.charAt(i))) {
                throw new IllegalArgumentException("Error: Last name cannot contain numbers.");
            }//exception handling
        }//end i loop
        this.lName = lName.substring(0, 1).toUpperCase() + lName.substring(1).toLowerCase();
    }//end set lName

    public String toString() { //prints proper name format
        if (middleInitial != null && !middleInitial.isEmpty()) {
            return fName + " " + middleInitial + ". " + lName;
        } else {
            return fName + " " + lName;
        }
    }//end toString method

} // end Name class