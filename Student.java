public class Student {

    private Name name;
    private Date dateOfBirth;
    private float gpa;
    private int creditsTaken;

    public Student(Name name, Date dateOfBirth, float gpa, int creditsTaken) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        setGpa(gpa);
        setCreditsTaken(creditsTaken);
    }//end Student constructor with fields

    public float getGpa() {
        return gpa;
    }//end get gpa

    public void setGpa(float gpa) {
        if(gpa < 0.0 || gpa > 5.0) {
            throw new IllegalArgumentException("Invalid. Gps must be between 0.0 and 5.0");
        }//exception handling
        this.gpa = gpa;
    }//end set gpa


    public int getCreditsTaken() {
        return creditsTaken;
    }//end get creditsTaken

    public void setCreditsTaken(int creditsTaken) {
        if(creditsTaken < 0 || creditsTaken > 200) {
            throw new IllegalArgumentException("Invalid. Credits taken must be between 0 and 200.");
        }//exception handling
        this.creditsTaken = creditsTaken;
    }//end set creditsTaken

    public String toString() {
        String result = "";
        result = "Name: " + name + "\nDate of birth: " + dateOfBirth + "\nGPA: " + gpa + "\nCredits taken: " + creditsTaken + "\n\n";
        return result;
    }//end toString method


} // end class