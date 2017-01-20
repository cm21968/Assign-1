public class Monthly extends Appointment
{
    
    public int nDay;
    
    // MAYBE CORRECT
    public Monthly(int nHour, int nDay, String Desc, Person obPerson)
    {
        super(nHour);
        this.nDay = nDay;
        this.sDescription = Desc;
        this.obPerson = obPerson;
    }

    // MAYBE CORRECT
    public boolean equals(Object other)
    {
        boolean bResult = false;        
        if (other != null && other instanceof Monthly)
        {
            Monthly obMonthly = (Monthly) other;
            bResult = (this.nDay == obMonthly.nDay);
        }
        return bResult;
    }
    
    // MAYBE CORRECT
    public String toString()
    {
        return super.toString() + "Day: " + nDay;
    }

    // MAYBE CORRECT
    public boolean occursOn( int nDay, int nMonth )
    {
        if (this.nDay == nDay)
        {
            return true;
        }
        else
        {
        return false;
        }
    }

    public boolean getEarly()
    {
        if (nHour < 10)
        {
            return true;
        }
        return false;
    }

}
