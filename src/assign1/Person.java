package assign1;
/**
 * <b>Purpose:</b> This is the class that creates a Person which then is used as
 * a parameter within Appointment and its sub-classes.
 * 
 * @author ConnorMoore CST134
 * @version 1.0
 */
public class Person
{
    private String sFirst;
    private String sLast;

    /**
     * Constructor for the Person class.
     * 
     * @param sFirst
     * @param sLast
     */
    public Person(String sFirst, String sLast)
    {
        this.sFirst = sFirst;
        this.sLast = sLast;
    }

    /**
     * <b>Purpose:</b> This boolean method checks the first and last name of the
     * Person against the other instance of Person. Returning true or false.
     * 
     * @param other
     * @return True if the Other instance of Person is equal to this person,
     *         otherwise False.
     */
    public boolean equals( Object other )
    {
        boolean bResult = false;

        if ( other != null && other instanceof Person )
        {
            Person obOtherName = (Person) other;
            bResult = (this.sFirst.equals(obOtherName.sFirst) && this.sLast
                    .equals(obOtherName.sLast));
        }
        return bResult;
    }

    /**
     * <b>Purpose:</b> This is a simple method that takes the Person attributes
     * and returns them in a String.
     * 
     * @return String version of the Person attributes.
     */
    public String toString()
    {
        return "\tFirst Name: " + this.sFirst + "\tLast Name: " + this.sLast;
    }
}
