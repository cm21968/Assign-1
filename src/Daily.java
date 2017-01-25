public class Daily extends Appointment
{

    public Daily(int nHour, String Desc, Person obPerson)
    {
        super(nHour);
    }
    
    // MAYBE COMPLETE
    public boolean equals(Object other)
    {
        boolean bResult = false;
        
        if (other != null && other instanceof Daily)
        {
            Daily obDaily = (Daily) other;
            bResult = (nHour == obDaily.nHour);
        }
        return bResult;
    }
    
    
    // MAYBE CORRECT
    public String toString()
    {
        return "Time: " + nHour;
    }
    
    
    // MAYBE CORRECT
    public boolean occursOn( int nDay, int nMonth )
    {
        return true;
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
