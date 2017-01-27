package assign1;

/**
 * Purpose: This is a sub-class of Appointment in which handles the OneTime
 * Appointment creation.
 *
 * @author ConnorMoore CST134
 * @version 1.0
 */
public class OneTime extends Appointment
{
    private int nDay;
    private int nMonth;

    /**
     * Constructor for the OneTime class.
     * 
     * @param nDay
     * @param nHour
     * @param nMonth
     * @param Desc
     * @param obPerson
     */
    public OneTime(int nDay, int nHour, int nMonth, String Desc, Person obPerson)
    {
        super(nHour);

        this.nDay = nDay;
        this.nMonth = nMonth;
        this.sDescription = Desc;
        this.obPerson = obPerson;
    }

    /**
     * Purpose: This an abstract method from the Appointment class. It is a
     * boolean check if the given OneTime Appointment occurs on the day and
     * month passed in as parameters.
     * 
     * @param nDay
     * @param nMonth
     * @return True or False depending on whether or not the Appointment occurs
     *         on the given date.
     */
    public boolean occursOn( int nDay, int nMonth )
    {
        if ( this.nDay == nDay && this.nMonth == nMonth )
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Purpose: This is an equals method checking if an instance of OneTime is
     * equal to another instance of OneTime.
     * 
     * @param other
     * @return True or False depending on whether or not the Other OneTime is
     *         equal to another one.
     */
    public boolean equals( Object other )
    {
        boolean bResult = false;

        if ( other != null && other instanceof OneTime )
        {
            OneTime obOneTime = (OneTime) other;
            bResult = (super.nHour == obOneTime.nHour
                    && this.nDay == obOneTime.nDay && this.nMonth == obOneTime.nMonth);
        }
        return bResult;

    }

    /**
     * Purpose: A simple method that takes the OneTime Appointment attributes
     * and returns them all in the form of a String.
     * 
     * @return String version of a OneTime Appointment.
     */
    public String toString()
    {
        if ( nHour < 10 || nDay < 10 || nMonth < 10 )
        {
            return "Month: " + this.nMonth + "\tDay: " + this.nDay
                    + "\t\tTime: " + nHour + "\tReason: " + sDescription
                    + "\t\t" + obPerson + "\n";
        }
        return "Month: " + this.nMonth + "\tDay: " + this.nDay + "\t\tTime: "
                + nHour + "\t\tReason: " + sDescription + obPerson + "\n";
    }

    /**
     * Purpose: A getter that returns the private int nDay so it can be accessed
     * by the Schedule class.
     * 
     * @return OneTime attribute "nDay".
     */
    public int getDay()
    {
        return nDay;
    }

    /**
     * Purpose: A getter that returns the private int nMonth so it can be
     * accessed by the Schedule class.
     * 
     * @return OneTime attribute "nMonth".
     */
    public int getMonth()
    {
        return nMonth;
    }

}
