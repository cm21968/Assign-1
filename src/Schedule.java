import java.util.ArrayList;


public class Schedule
{
    // THIS IS MOST LIKELY NOT CORRECT
    OneTime obOneTime;
    Monthly obMonthly;
    Daily obDaily;

    Appointment obAppointment;

    
    public ArrayList<Appointment> colAppointments = new ArrayList<Appointment>();
    
    public Schedule()
    {
        colAppointments = new ArrayList<Appointment>();
    }
 
    // MAYBE WORKING
    public boolean free(int nHour, int nDay, int nMonth) {
        for (Appointment appointment : colAppointments) {
            if (appointment.occursOn(nDay, nMonth)
                && appointment.getnHour() == nHour)
                return false;
        }

        return true;
    }
    
    // MAYBE COMPLETE
    public int numAppoint(int nDay, int nMonth)
    {
        int apmtTotal = 0;
                                
    
       System.out.println(freeTimes(nDay, nMonth).length);

        
        return apmtTotal;
    }
    
    // MAYBE WORKING
	public boolean add(Appointment obApp) {
        if (obApp instanceof OneTime) {
            if (free(obApp.getnHour(), ((OneTime) obApp).getDay(), ((OneTime) obApp).getMonth())) {
                this.colAppointments.add(obApp);
                return true;
            }
        }
        else if (obApp instanceof Monthly) {
            if (free(obApp.getnHour(), ((Monthly) obApp).nDay, 0)) {
                this.colAppointments.add(obApp);        
                return true;
            }
        }
        else {
            if (free(obApp.getnHour(), 0, 0)) {
                this.colAppointments.add(obApp);
                return true;
            }
            
        }
		return false;
        }
  
    // MAYBE WORKING
     public boolean delete(Appointment obApp) {
	    for (Appointment appointment : colAppointments) {
	        if (appointment.equals(obApp)) {
	            colAppointments.remove(colAppointments.indexOf((appointment)));
	            return true;
	        }
	    }
		return false;
     }
    
    // MAYBE WORKING
    public String getDailySchedule(int nDay, int nMonth)
    {
        colAppointments.subList(nDay, nDay);
        return colAppointments.subList(nDay, nDay).toString();
    }
    
    // MAYBE WORKING THE IF DOES NOT TAKE INTO ACCOUNT THE POSITION OF i SO THAT WILL PROBABLY NOT WORK
    public ArrayList<Appointment> getAppList(Person obPerson)
    {
        for (Appointment obApp : colAppointments)
        {
            if (obApp.forPerson(obPerson))
            {
                int nIndex = colAppointments.indexOf(obApp);
                colAppointments.get(nIndex).toString();
            }
        }
        return colAppointments;
    }
    
    // THIS IS WORKING
    public int[] freeTimes(int nDay, int nMonth)
    {

        int nHour = 8;
        int arrayPos = 0;
        int[] open = new int[17];
        int[] test = new int[17];
        
        while (nHour <= 17)
        {     	
        	if(free(nHour, nDay, nMonth) == false)
            {
        		open[arrayPos] = nHour;
                System.out.println(nHour + ":00 :    " + "Not Available");
            	System.out.println("------------------------------------------------------------------");            	
            }
        	else if (free(nHour, nDay, nMonth))
        	{
        		open[arrayPos] = nHour;
                System.out.println(open[arrayPos] + ":00 :");
            	System.out.println("------------------------------------------------------------------");
        	}
        	else
        	{
        		
        	}
        		
            arrayPos++;
            nHour++;
        }     
        System.out.println();

        return test;                   
    }
}
