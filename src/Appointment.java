public abstract class Appointment implements EarlyMorning
{
    protected String sDescription;
    protected int nHour;
    protected Person obPerson;
    
    // CORRECT
    public Appointment(int nHour)
    {
        this.nHour = nHour;
    }
    
    // CORRECT
    public abstract boolean occursOn(int nDay, int nMonth);
   
    // MAYBE CORRECT
    public boolean forPerson(Person obPerson)
    {
        this.obPerson = obPerson;
        if (this.obPerson.equals(obPerson))
        {
            return false;
        }
        return true;
    }
    
    // MAYBE CORRECT
    public String toString()
    {
        return "\tTime: " + nHour + "\nFor: " + obPerson.toString() + "Reason: " + sDescription;
    }
    
    public int getnHour()
    {
    	return nHour;
    }
}
