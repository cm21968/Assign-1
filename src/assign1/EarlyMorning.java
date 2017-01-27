package assign1;
/**
 * Purpose: This is an interface in which initializes getEarly() and then is
 * implemented by the Appointment class. getEarly() is then implemented by
 * OneTime, Daily and Monthly as they are child classes.
 * 
 * @author ConnorMoore CST134
 * @version 1.0
 */
public interface EarlyMorning
{
    boolean getEarly();
}
