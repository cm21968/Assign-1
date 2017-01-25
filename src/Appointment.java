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
        if (this.obPerson.equals(obPerson) && obPerson != null)
        {
            return true;
        }
        return false;
    }
    
    // MAYBE CORRECT
    public String toString()
    {
        return "Time: " + nHour + "\nFor: " + obPerson.toString() + "\nReason: " + sDescription;
    }
    
    public int getnHour()
    {
    	return nHour;
    }
}
