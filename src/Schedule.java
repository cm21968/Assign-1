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
            if (appointment.occursOn(nDay, nMonth) && appointment.nHour == nHour)
            {
                return false;
            }
        }

        return true;
    }
    
    // MAYBE COMPLETE
    public int numAppoint(int nDay, int nMonth)
    {
        int apmtTotal = 0;
                                
    

        for (Appointment obApp : colAppointments)
        {
        	if (obApp.occursOn(nDay, nMonth))
        	{
        		apmtTotal++;
        	}
        }      
        return apmtTotal;
    }
    
    // MAYBE WORKING
	public boolean add(Appointment obApp) {
        if (obApp instanceof OneTime) {
            if (free(obApp.nHour, ((OneTime) obApp).getDay(), ((OneTime) obApp).getMonth())) {
                this.colAppointments.add(obApp);
                return true;
            }
            return false;
        }
        else if (obApp instanceof Monthly) {
            
            
            if (free(obApp.getnHour(), ((Monthly) obApp).nDay, 0)) {
                this.colAppointments.add(obApp);        
                return true;
            }
        }
        else {
            int dCount = 0;
            int mCount = 0;
            int fCount = 0;
            while (fCount <= 365)
            {
                while (mCount <= 12)
                {
                    while(dCount <= 31)
                    {
                        if (free(obApp.nHour, dCount, mCount)) {
                            fCount++;
                        }
                        else
                        {
                           System.out.println("meme");
                        }
                        dCount++;
                    }
                    if (dCount >= 31)
                    {
                        mCount++;
                        dCount = 0;
                    }
                }
            }
            
            if (fCount >= 365)
            {
                dCount = 0;
                mCount = 1;
                while (mCount <= 12)
                {
                    while(dCount <= 31)
                    {
                        if (free(obApp.nHour, dCount, mCount)) {
                            colAppointments.add(obApp);
                            return true;
                        }
                        else
                        {
                           System.out.println("meme");
                        }
                        dCount++;
                    }
                    if (dCount >= 31)
                    {
                        mCount++;
                        dCount = 0;
                    }
                }
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
        //int nHour = 8;
        String schedule = "***********************************************DAILY SCHEDULE************************************************\n\n";
        
        for (Appointment appointment : colAppointments)
        {
            if (appointment.occursOn(nDay, nMonth))
            {
                schedule = schedule + appointment.toString() + " \n" + "\n*************************************************************************************************************\n";
            }
        }
        
        return schedule;
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
        int[] open = new int[50];
        int[] test = new int[50];
        
    	System.out.println("------------------------------------------------------------------");

        while (nHour <= 17)
        {     	
        	if(free(nHour, nDay, nMonth) == false)
            {
        		if (nHour < 10)
        		{
                	System.out.println(nHour + ":00 :    " + "Not Available" + "\t\t\t\t\t\t " + "|");
                	System.out.println("------------------------------------------------------------------");
        		}
        		else
        		{
        			System.out.println(nHour + ":00 :    " + "Not Available" + "\t\t\t\t\t " + "|");
                	System.out.println("------------------------------------------------------------------");
        		}
            }
        	else if (free(nHour, nDay, nMonth))
        	{
        		open[arrayPos] = nHour;
                System.out.println(open[arrayPos] + ":00 :" + "\t\t\t\t\t\t\t\t " + "|");
            	System.out.println("------------------------------------------------------------------");
        	}
        	else
        	{
        		
        	}        		
            arrayPos++;
            nHour++;
        }     
        arrayPos = 0;
                
    	System.out.println("*************************FREE HOURS*******************************");
    						
        int nCount = 1;
    	
        for (int i = 0; i <= open.length - 1; i++)
        {
        	if (open[arrayPos] > 0)
        	{
        		test[arrayPos] = open[arrayPos];
        		if (open[arrayPos] >= 12)
        		{
        			if (nCount <= 4)
        			{
        				System.out.print(test[arrayPos] + ":00 P.M.\t");
        				nCount++;
        			}
        			else
        			{
        				System.out.print("\n" + test[arrayPos] + ":00 P.M.\t");
        				nCount = 0;
        			}
        			
        		}
        		else
        		{
        			if (nCount <= 4)
        			{
        				System.out.print(test[arrayPos] + ":00 A.M.\t");
        				nCount++;
        			}
        			else
        			{
        				System.out.print("\n" + test[arrayPos] + ":00 A.M.\t");
        				nCount = 0;
        			}
        			
        		}
        	}             	
        	arrayPos++;
        }
        System.out.println("\n******************************************************************");        
        System.out.println("\n\n\n");
        
        return test;                   
        
    }
   }
    

