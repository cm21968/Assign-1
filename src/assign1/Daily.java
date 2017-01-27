package assign1;

/**
 * <b>Purpose:</b> This is a sub-class of Appointment, allowing you to create an
 * appointment that occurs every day.
 * 
 * @author ConnorMoore CST134
 * @version 1.0
 */
public class Daily extends Appointment
{

    /**
     * Constructor for the Daily class.
     * 
     * @param nHour
     * @param Desc
     * @param obPerson
     */
    public Daily(int nHour, String Desc, Person obPerson)
    {
        super(nHour);

        this.sDescription = Desc;
        this.obPerson = obPerson;
    }

    /**
     * <b>Purpose:</b> This is an equals method checking if an instance of Daily
     * is equal to another instance of Daily.
     * 
     * @param other
     * @return Returns True if one instance of Daily is equal to another
     *         instance of Daily, otherwise False.
     */
    public boolean equals( Object other )
    {
        boolean bResult = false;

        if ( other != null && other instanceof Daily )
        {
            Daily obDaily = (Daily) other;
            bResult = (nHour == obDaily.nHour);
        }
        return bResult;
    }

    /**
     * <b>Purpose:</b> A simple method that takes the Daily Appointment
     * attributes and returns them in the form of a String.
     * 
     * @return String version of a Daily Appointment.
     */
    public String toString()
    {
        return "\t\t\t" + super.toString() + "\n";
    }

    /**
     * <b>Purpose:</b> This an abstract method from the Appointment class. It is
     * a boolean check if the given Daily Appointment occurs on the day and
     * month passed in as parameters.
     * 
     * @param nDay
     * @param nMonth
     * @return Daily Appointment will always return True.
     */
    public boolean occursOn( int nDay, int nMonth )
    {
        return true;
    }

}
