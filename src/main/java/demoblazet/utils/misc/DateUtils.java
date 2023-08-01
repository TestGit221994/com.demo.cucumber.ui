package demoblazet.utils.misc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class DateUtils {
    private static final LocalDate date = LocalDate.now();
    private static final Calendar cal = Calendar.getInstance();

    public static String getCurrentDate(String pattern) {
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String getTomorrowDate() {
        return (date.plusDays(1)).format(DateTimeFormatter.ofPattern("d"));
    }

    public static String getTomorrowDate(String format, int futureDate) {
        return (date.plusDays(futureDate)).format(DateTimeFormatter.ofPattern(format));
    }
}