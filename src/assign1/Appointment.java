package assign1;

public abstract class Appointment implements EarlyMorning
{
    protected String sDescription;
    protected int nHour;
    protected Person obPerson;

    /**
     * Constructor for the Appointment class.
     * 
     * @param nHour
     */
    public Appointment(int nHour)
    {
        this.nHour = nHour;
    }

    /**
     * Purpose: This is an abstract method which is used by the sub-classes,
     * checking if the given appointment occurs on the day and month entered.
     * 
     * @param nDay
     * @param nMonth
     * @return True or False depending if the appointment occurs on the given
     *         date.
     */
    public abstract boolean occursOn( int nDay, int nMonth );

    /**
     * Purpose: This is a simple check to see of the Person assigned to the
     * appointment is equal to the Person being passed in as a parameter.
     * 
     * @param obPerson
     * @return True or False depending on whether or not Person equals Other
     *         Person.
     */
    public boolean forPerson( Person obPerson )
    {
        if ( this.obPerson.equals(obPerson) )
        {
            return false;
        }
        return true;
    }

    /**
     * Purpose: Returns an appointment and its attributes converted into a
     * string.
     * 
     * @return Appointment Attributes
     */
    public String toString()
    {
        if ( nHour < 10 )
        {
            return "\tTime: " + nHour + "\t\t" + "Reason: " + sDescription
                    + "\t" + obPerson;
        }
        return "\tTime: " + nHour + "\t" + "Reason: " + sDescription + "\t\t"
                + obPerson;
    }

    /**
     * Purpose: Returning nHour allowing it to be called from the Schedule
     * class.
     * 
     * @return nHour
     */
    public int getnHour()
    {
        return nHour;
    }

    /**
     * Purpose: Returning nHour allowing it to be called from the Schedule
     * class.
     * 
     * @return nHour
     */
    public boolean getEarly()
    {
        return nHour < 10;
    }
}
