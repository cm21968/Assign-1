
public class OneTime extends Appointment
{
    private int nDay;
    private int nMonth;
    
    // MAYBE CORRECT
    public OneTime(int nDay, int nHour, int nMonth, String Desc, Person obPerson)
    {
        super(nHour);
        
        this.nDay = nDay;
        this.nMonth = nMonth;
        this.sDescription = Desc;
        this.obPerson = obPerson;
    }

    // MAYBE CORRECT
    public boolean occursOn(int nDay, int nMonth)
    {
        if (this.nDay == nDay && this.nMonth == nMonth)
        {
            return true;
        }
        else
        {
            return false;
        }
    }    
    
    // MAYBE CORRECT
    public boolean equals(Object other)
    {   
        boolean bResult = false;
        
        if (other != null && other instanceof OneTime)
        {
            OneTime obOneTime = (OneTime) other;
            bResult = (super.nHour == obOneTime.nHour && this.nDay == obOneTime.nDay && this.nMonth == obOneTime.nMonth);
        }
        return bResult;
        
    }
    
    // MAYBE RIGHT
    public String toString()
    {
        return "Month: " + this.nMonth + "\tDay: " + this.nDay + "\tTime: " + nHour + "\tReason: " + sDescription + "\tFor: " + obPerson;
    }
    
    public int getDay()
    {
        return nDay;
    }
    
    public int getMonth()
    {
        return nMonth;
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
