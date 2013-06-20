import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * A basic lifetime calculator.
 *
 * @author Michael Mardaus
 * @author Julian Rost
 * @since 20.06.2013
 */
public class LifeTime {
    /**
     * the date of birth.
     */
    private static GregorianCalendar dateOfBirth;

    /**
     * @return the dateOfBirth
     */
    protected final GregorianCalendar getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * full constructor.
     * @param year the year
     * @param month the true month (one-based)
     * @param day the day
     * @param hour the hour
     * @param minute the minute
     * @param second the second
     */
    public LifeTime(final int year, final int month, final int day,
                     final int hour, final int minute, final int second) {
        int realMonth = month - 1;
        dateOfBirth = new GregorianCalendar(year, realMonth,
                day, hour, minute, second);
    }

    /**
     * constructor without seconds.
     * @param year the year
     * @param month the true month (one-based)
     * @param day the day
     * @param hour the hour
     * @param minute the minute
     */
    public LifeTime(final int year, final int month, final int day,
                     final int hour, final int minute) {
        int realMonth = month - 1;
        dateOfBirth = new GregorianCalendar(year, realMonth, day,
                hour, minute, 0);
    }

    /**
     * constructor without time.
     * @param year the year
     * @param month the true month (one-based)
     * @param day the day
     */
    public LifeTime(final int year, final int month, final int day) {
        int realMonth = month - 1;
        dateOfBirth = new GregorianCalendar(year, realMonth, day, 0, 0, 0);
    }

    /**
     * get the year of the date.
     * @return year
     */
    public final int getYear() {
        return dateOfBirth.get(Calendar.YEAR);
    }
     /**
      * get the true month of the date.
      * @return one-based month
      */
    public final int getMonth() {
        return dateOfBirth.get(Calendar.MONTH) + 1;
    }

    /**
     * get the day of the date.
     * @return day
     */
    public final int getDayOfMonth() {
        return dateOfBirth.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * get the weekday index of the date.
     * @return weekday index
     */
    public final int getDayOfWeek() {
        return dateOfBirth.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * get the hour of the date.
     * @return 24h based hour
     */
    public final int getHour() {
        return dateOfBirth.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * get the minute of the date.
     * @return minute
     */
    public final int getMinute() {
        return dateOfBirth.get(Calendar.MINUTE);
    }

    /**
     * get the second of the date.
     * @return second
     */
    public final int getSecond() {
        return dateOfBirth.get(Calendar.SECOND);
    }

    /**
     * get the time in years that have passed.
     * @return number of years
     */
    public final long ageInYears() {
        GregorianCalendar now = new GregorianCalendar();
        long diff = now.getTime().getTime() - dateOfBirth.getTime().getTime();
        return diff / (1000L * 60 * 60 * 24 * 365);
    }

    /**
     * get the time in days that have passed.
     * @return number of days
     */
    public final long ageInDays() {
        GregorianCalendar now = new GregorianCalendar();
        long diff = now.getTime().getTime() - dateOfBirth.getTime().getTime();
        return diff / (1000L * 60 * 60 * 24);
    }

    /**
     * get the time in hours that have passed.
     * @return number of hours
     */
    public final long ageInHours() {
        GregorianCalendar now = new GregorianCalendar();
        long diff = now.getTime().getTime() - dateOfBirth.getTime().getTime();
        return diff / (1000L * 60 * 60);
    }

    /**
     * get the time in minutes that have passed.
     * @return number of minutes
     */
    public final long ageInMinutes() {
        GregorianCalendar now = new GregorianCalendar();
        long diff = now.getTime().getTime() - dateOfBirth.getTime().getTime();
        return diff / (1000L * 60);
    }

    /**
     * get the time in seconds that have passed.
     * @return number of seconds
     */
    public final long ageInSeconds() {
        GregorianCalendar now = new GregorianCalendar();
        long diff = now.getTime().getTime() - dateOfBirth.getTime().getTime();
        return diff / (1000L);
    }

    /**
     * the main method.
     * @param args command line parameters
     */
    public static void main(final String[] args) {

        LifeTime lt = new LifeTime(2013,6,19,15,45);
        System.out.println("Anzahl der gelebten Sekunden seit "
        + lt.getDateOfBirth().getTime());
        System.out.println(lt.ageInSeconds());
        System.out.println("Anzahl der gelebten Tage seit "
        + lt.getDateOfBirth().getTime());
        System.out.println(lt.ageInDays());
        System.out.println("Anzahl der Herzschläge seit "
        + lt.getDateOfBirth().getTime());
        System.out.println(lt.ageInMinutes() * 70);
    }

}
