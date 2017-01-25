
public class Person
{
    private String sFirst;
    private String sLast;
    
    public Person (String sFirst, String sLast)
    {
        this.sFirst = sFirst;
        this.sLast = sLast;
    }
    
    
    // THIS MIGHT NOT BE CORRECT IF THERE IS ISSUES CHECK THIS
    public boolean equals (Object other)
    {
        boolean bResult = false;
        
        if (other != null && other instanceof Person)
        {
            Person obOtherName = (Person) other;
            bResult = (this.sFirst.equals(obOtherName.sFirst) && this.sLast.equals(obOtherName.sLast));
        }
        return bResult;
    }
    
    // MAYBE CORRECT
    public String toString()
    {
        return "First Name: " + this.sFirst + "\tLast Name: " + this.sLast;
    }
}
