package assign1;
import java.util.Random;

/**
 * <b>Purpose:</b> testClass.java is used to test all of the methods which were
 * created in the Schedule class. Testing the add or delete methods for example.
 * 
 * @author ConnorMoore CST134
 * @version 1.0
 */
public class testClass
{
    /**
     * <b>Purpose:</b> This is the main method that runs and tests the program.
     * 
     * @param args
     */
    public static void main( String[] args )
    {
        Schedule sched = new Schedule();
        Person tom = new Person("Tom", "Memes");
        Person john = new Person("John", "Dank");

        Random randDay = new Random();
        Random randMonth = new Random();
        Random randHour = new Random();

        Monthly obMonthly1 = new Monthly(10, 23, "Stroke", tom);

        sched.add(obMonthly1);

        sched.freeTimes(23, 10);

        sched.getAppList(tom);

        // sched.delete(obMonthly1);

        sched.getAppList(tom);

        int counter = 0;

        OneTime obOneTime = new OneTime(23, 10, 6, "Even Worse Stroke", tom);

        sched.add(obOneTime);

        Daily obDaily1 = new Daily(8, "Cancer", tom);
        sched.add(obDaily1);

        /*
         * 
         * Daily obDaily2 = new Daily(9, "Cancer", tom); Daily obDaily3 = new
         * Daily(10, "Cancer", tom); Daily obDaily4 = new Daily(11, "Cancer",
         * tom); Daily obDaily5 = new Daily(12, "Cancer", tom); Daily obDaily6 =
         * new Daily(13, "Cancer", tom); Daily obDaily7 = new Daily(14,
         * "Cancer", tom); Daily obDaily8 = new Daily(15, "Cancer", tom); Daily
         * obDaily9 = new Daily(16, "Cancer", tom); Daily obDaily10 = new
         * Daily(17, "Cancer", tom);
         * 
         * 
         * sched.add(obDaily2); sched.add(obDaily3); sched.add(obDaily4);
         * sched.add(obDaily5); sched.add(obDaily6); sched.add(obDaily7);
         * sched.add(obDaily8); sched.add(obDaily9); sched.add(obDaily10);
         * sched.add(christmasTests);
         */
        /*
         * sched.add(obOneTime1); sched.freeTimes(6, 4);
         * sched.delete(obOneTime1); sched.freeTimes(6, 4); sched.add(obDaily);
         * sched.freeTimes(6, 4);
         */

        int nDay = 0;
        int nMonth = 0;
        int nTime = 0;

        int nDay2 = 0;
        int nMonth2 = 0;
        int nTime2 = 0;

        while ( counter <= 80 )
        {
            nDay = (int) randDay.nextInt(32);
            nMonth = (int) randMonth.nextInt(13);
            nTime = (int) randHour.nextInt(18);

            nDay2 = (int) randDay.nextInt(32);
            nMonth2 = (int) randMonth.nextInt(13);
            nTime2 = (int) randHour.nextInt(18);

            if ( nDay == 0 )
            {
                nDay++;
            }
            if ( nMonth == 0 )
            {
                nMonth++;
            }
            while ( nTime < 8 )
            {
                nTime = (int) randHour.nextInt(18);
            }

            if ( nDay2 == 0 )
            {
                nDay2++;
            }
            if ( nMonth2 == 0 )
            {
                nMonth2++;
            }
            while ( nTime2 < 8 )
            {
                nTime2 = (int) randHour.nextInt(18);
            }

            OneTime obOneTime2 = new OneTime(nDay, nTime, nMonth, "Back Pain",
                    tom);
            OneTime obOneTime3 = new OneTime(nDay2, nTime2, nMonth2, "Memes",
                    john);

            sched.add(obOneTime2);
            sched.add(obOneTime3);
            // System.out.println("Day: " + nDay + " \tMonth: " + nMonth +
            // "\tHour: " + nTime);

            counter++;
        }

        System.out.println(sched.getDailySchedule(nDay, nMonth));

        // sched.freeTimes(nDay, nMonth);
        sched.freeTimes(3, 5);
        sched.freeTimes(14, 12);

        System.out.println();
        System.out.println();
        System.out.println();
        sched.freeTimes(nDay, nMonth).toString();

        System.out.println(sched.getAppList(john));
        System.out.println(sched.getDailySchedule(nDay, nMonth));
        sched.getEMorning(nDay, nMonth).toString();

    }
}
