package assign1;
import java.util.ArrayList;

/**
 * <b>Purpose:</b> This class handles all of the methods that view or modify the
 * ArrayList of Appointments. For example there is an add method that allows you
 * to insert new Appointments into the ArrayList.
 * 
 * @author ConnorMoore
 * @version 1.0
 */
public class Schedule
{
    OneTime obOneTime;
    Monthly obMonthly;
    Daily obDaily;

    Appointment obAppointment;

    public ArrayList<Appointment> colAppointments = new ArrayList<Appointment>();

    /**
     * Constructor for the Schedule class.
     */
    public Schedule()
    {
        colAppointments = new ArrayList<Appointment>();
    }

    /**
     * <b>Purpose:</b> This method takes the parameters and runs through the
     * colAppointments checking if there is already an Appointment booked on the
     * same time and day as the values passed in.
     * 
     * @param nHour
     * @param nDay
     * @param nMonth
     * @return True if there is no Appointment in the ArrayList already occuring
     *         on that date, otherwise false.
     */
    public boolean free( int nHour, int nDay, int nMonth )
    {
        for ( Appointment appointment : colAppointments )
        {
            if ( appointment.occursOn(nDay, nMonth)
                    && appointment.nHour == nHour )
            {
                return false;
            }
        }

        return true;
    }

    /**
     * <b>Purpose:</b> This is a simple method which will allow you to view the
     * number of Appointments for the given day.
     * 
     * @param nDay
     * @param nMonth
     * @return An integer telling you the number of Appointments for the given
     *         day.
     */
    public int numAppoint( int nDay, int nMonth )
    {
        int apmtTotal = 0;

        for ( Appointment obApp : colAppointments )
        {
            if ( obApp.occursOn(nDay, nMonth) )
            {
                apmtTotal++;
            }
        }
        return apmtTotal;
    }

    // FIX THE MONTHLY ADD BEFORE SUBMISSION

    /**
     * <b>Purpose:</b> add() is the method that handles checking what type of
     * Appointment they are entering, if the requested position is free (checked
     * by using the free() method). Then it will insert the new Appointment
     * within the ArrayList.
     * 
     * @param obApp
     * @return True if the appointment was added to the ArrayList, otherwise
     *         false.
     */
    public boolean add( Appointment obApp )
    {
        if ( obApp instanceof OneTime )
        {
            if ( free(obApp.nHour, ((OneTime) obApp).getDay(),
                    ((OneTime) obApp).getMonth()) )
            {
                this.colAppointments.add(obApp);
                return true;
            }
            return false;
        }
        else if ( obApp instanceof Monthly )
        {
            /**
             * int monthCount = 1; int nCount = 1;
             * 
             * while (monthCount <= 12) { if (free(obApp.getnHour(), ((Monthly)
             * obApp).nDay, monthCount)) { nCount++; } else { return false; }
             * monthCount++; } monthCount = 1; if (nCount >= 12) {
             * while(monthCount < 12) { if (free(obApp.nHour, ((Monthly)
             * obApp).nDay, monthCount )) { colAppointments.add(obApp); } else {
             * 
             * } monthCount++; } return true; }
             **/
            int mCount = 1;

            while ( mCount <= 12 )
            {
                if ( free(obApp.nHour, ((Monthly) obApp).nDay, mCount) )
                {

                }
                else
                {
                    return false;
                }

                mCount++;
            }

            mCount = 1;
            while ( mCount <= 12 )
            {
                if ( free(obApp.nHour, ((Monthly) obApp).nDay, mCount) )
                {
                    colAppointments.add(obApp);
                    return true;
                }
                else
                {
                    System.out.println("meme");
                }
                if ( mCount < 12 )
                {
                    mCount++;
                }
            }
            return true;
        }

        else
        {
            int dCount = 1;
            int mCount = 1;
            int fCount = 0;
            while ( fCount <= 365 )
            {
                while ( mCount <= 12 )
                {
                    while ( dCount <= 31 )
                    {
                        if ( free(obApp.nHour, dCount, mCount) )
                        {
                            fCount++;
                        }
                        else
                        {
                            return false;
                        }
                        dCount++;
                    }
                    if ( dCount >= 31 )
                    {
                        mCount++;
                        dCount = 0;
                    }
                }
            }

            if ( fCount >= 365 )
            {
                dCount = 0;
                mCount = 1;
                while ( mCount <= 12 )
                {
                    while ( dCount <= 31 )
                    {
                        if ( free(obApp.nHour, dCount, mCount) )
                        {
                            colAppointments.add(obApp);
                            return true;
                        }
                        else
                        {
                            System.out.println("meme");
                        }
                        dCount++;
                    }
                    if ( dCount >= 31 )
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

    /**
     * <b>Purpose:</b> delete() is a method that handles deleting Appointments
     * from the ArrayList. Runs through an advanced for loop until it finds a
     * matching Appointment to the one passed in. If matching Appointment is not
     * found return false.
     * 
     * @param obApp
     * @return True if it finds a matching Appointment and removes it from the
     *         ArrayList, otherwise False.
     */
    public boolean delete( Appointment obApp )
    {
        for ( Appointment appointment : colAppointments )
        {
            if ( appointment.equals(obApp) )
            {
                colAppointments.remove(colAppointments.indexOf((appointment)));
                return true;
            }
        }
        return false;
    }

    /**
     * <b>Purpose:</b> This is a String function that loops through the
     * ArrayList checking if there are any Appointments on the same Day and
     * Month as the parameters entered. If it does find matching Appointments it
     * prints them in an organized manor.
     * 
     * @param nDay
     * @param nMonth
     * @return String schedule which is a String conversion of an Appointment on
     *         the matching day.
     */
    public String getDailySchedule( int nDay, int nMonth )
    {
        // int nHour = 8;
        String schedule = "***********************************************DAILY SCHEDULE************************************************\n\n";

        for ( Appointment appointment : colAppointments )
        {
            if ( appointment.occursOn(nDay, nMonth) )
            {
                schedule = schedule
                        + appointment.toString()
                        + " \n"
                        + "\n*************************************************************************************************************\n";
            }
        }

        return schedule;
    }

    /**
     * <b>Purpose:</b> getAppList() is a method that loops through all of the
     * Appointments in the ArrayList. Each time it is looping it checks whether
     * or not the Appointment is for the Person entered as a parameter. If it is
     * the
     * 
     * @param obPerson
     * @return ArrayList containing the appointments for the given person.
     */
    public ArrayList<Appointment> getAppList( Person obPerson )
    {
        for ( Appointment obApp : colAppointments )
        {
            if ( obApp.forPerson(obPerson) )
            {
                int nIndex = colAppointments.indexOf(obApp);
                colAppointments.get(nIndex).toString();
            }
        }
        return colAppointments;
    }

    /**
     * <b>Purpose:</b> freeTimes() is a method that takes the parameters nDay
     * and nMonth, then continues to check and see all of the Appointments on
     * that date. While doing this it adds the hours which currently are not
     * booked into an integer array.
     * 
     * @param nDay
     * @param nMonth
     * @return Integer Array holding the free hours on the given date.
     */
    public int[] freeTimes( int nDay, int nMonth )
    {
        int nHour = 8;
        int arrayPos = 0;
        int[] open = new int[50];
        int[] test = new int[50];

        System.out
                .println("------------------------------------------------------------------");

        while ( nHour <= 17 )
        {
            if ( free(nHour, nDay, nMonth) == false )
            {
                if ( nHour < 10 )
                {
                    System.out.println(nHour + ":00 :    " + "Not Available"
                            + "\t\t\t\t\t\t " + "|");
                    System.out
                            .println("------------------------------------------------------------------");
                }
                else
                {
                    System.out.println(nHour + ":00 :    " + "Not Available"
                            + "\t\t\t\t\t " + "|");
                    System.out
                            .println("------------------------------------------------------------------");
                }
            }
            else if ( free(nHour, nDay, nMonth) )
            {
                open[arrayPos] = nHour;
                System.out.println(open[arrayPos] + ":00 :"
                        + "\t\t\t\t\t\t\t\t " + "|");
                System.out
                        .println("------------------------------------------------------------------");
            }
            else
            {
            }
            arrayPos++;
            nHour++;
        }
        arrayPos = 0;

        System.out
                .println("*************************FREE HOURS*******************************");
        int nCount = 1;

        for ( int i = 0; i <= open.length - 1; i++ )
        {
            if ( open[arrayPos] > 0 )
            {
                test[arrayPos] = open[arrayPos];
                if ( open[arrayPos] >= 12 )
                {
                    if ( nCount <= 4 )
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
                    if ( nCount <= 4 )
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
        System.out
                .println("\n******************************************************************");
        System.out.println("\n\n\n");

        return test;

    }

    public Appointment[] getEMorning( int nDay, int nMonth )
    {
        Appointment[] aApp = new Appointment[730];
        int counter = 0;
        for ( Appointment obApp : colAppointments )
        {
            if ( obApp.getEarly() )
            {
                aApp[counter] = obApp;
            }
            counter++;
        }
        return aApp;
    }
}
