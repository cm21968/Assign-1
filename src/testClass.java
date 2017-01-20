import java.util.Random;


public class testClass
{
    public static void main( String[] args )
    {
        Schedule sched = new Schedule();
        Person tom = new Person("Tom", "Memes");
        Person john = new Person("John", "Dank");

        OneTime obOneTime1 = new OneTime(6, 11, 4, "Back Pain", tom);
        Daily obDaily = new Daily(14, "Cancer", tom);
        Random randDay = new Random();
        Random randMonth = new Random();
        Random randHour = new Random();
        int counter = 0;
        
        sched.add(obOneTime1);                        
        sched.freeTimes(6, 4);
        sched.delete(obOneTime1);                        
        sched.freeTimes(6, 4);
        sched.add(obDaily);                        
        sched.freeTimes(6, 4);
        
        while (counter <= 20)
        {
            int nDay = 1;    //(int) Math.floor(Math.random() + 30);
            int nMonth = 1;  //(int) Math.floor(Math.random() + 11);
            int nTime = 1;  //(int) Math.floor(Math.random() + 16);
            
            OneTime obOneTime2 = new OneTime((int)randDay.nextInt(31), randHour.nextInt(17), randMonth.nextInt(12), "Back Pain", tom);
            OneTime obOneTime3 = new OneTime((int)randDay.nextInt(31), randHour.nextInt(17), randMonth.nextInt(12), "Memes", john);

            sched.add(obOneTime2); 
            sched.add(obOneTime3);                                    

            counter++;
        }
        System.out.println(sched.getAppList(tom).toString());
        System.out.println();
        System.out.println(sched.getAppList(john));
    }

}
