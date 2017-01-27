package assign1;

/**
 * <b>Purpose:</b> This is a sub-class of Appointment, allowing you to create an
 * appointment that occurs at the same time every month.
 * 
 * @author ConnorMoore CST134
 * @version 1.0
 */
public class Monthly extends Appointment
{

    public int nDay;

    /**
     * Constructor for the Monthly class.
     * 
     * @param nHour
     * @param nDay
     * @param Desc
     * @param obPerson
     */
    public Monthly(int nHour, int nDay, String Desc, Person obPerson)
    {
        super(nHour);
        this.nDay = nDay;
        this.sDescription = Desc;
        this.obPerson = obPerson;
    }

    /**
     * <b>Purpose:</b> This is an equals method checking if an instance of
     * Monthly is equal to another instance of Monthly.
     * 
     * @param other
     * @return True or False depending on whether or not the Other instance of
     *         Monthly is equal to another one.
     */
    public boolean equals( Object other )
    {
        boolean bResult = false;
        if ( other != null && other instanceof Monthly )
        {
            Monthly obMonthly = (Monthly) other;
            bResult = (this.nDay == obMonthly.nDay);
        }
        return bResult;
    }

    /**
     * <b>Purpose:</b> A simple method that takes the OneTime Appointment
     * attributes and returns them all in the form of a String.
     * 
     * @return String version of a Monthly Appointment.
     */
    public String toString()
    {
        return "\t\tDay: " + nDay + "\t" + super.toString() + "\n";
    }

    /**
     * <b>Purpose:</b> This an abstract method from the Appointment class. It is
     * a boolean check if the given Monthly Appointment occurs on the day and
     * month passed in as parameters.
     * 
     * @param nDay
     * @param nMonth
     * @return True or False depending on whether or not the Appointment occurs
     *         on the given date.
     */
    public boolean occursOn( int nDay, int nMonth )
    {
        if ( this.nDay == nDay )
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * <b>Purpose:</b> This is a boolean method which is implemented from the
     * EarlyMorning interface, by the Appointment class then distributed to the
     * child classes of Appointment.
     * 
     * @return True if Monthly Appointment is booked before 10 AM, otherwise
     *         False.
     */
    public boolean getEarly()
    {
        if ( nHour < 10 )
        {
            return true;
        }
        return false;
    }

}
