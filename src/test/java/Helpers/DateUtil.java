package Helpers;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static Date getTomorrowDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    public static String[] getTomorrowDateFields() {
        Date dateTomorrow = getTomorrowDate();
        SimpleDateFormat df = new SimpleDateFormat("d MMMM yyyy");
        return df.format(dateTomorrow).split(" ");

    }


    public static String[] addDaysToTomorrow(int addDays) {
        Date dateTomorrow = getTomorrowDate();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateTomorrow);
        cal.add(Calendar.DAY_OF_MONTH, addDays);
        Date tomorrowPlusDays = cal.getTime();
        SimpleDateFormat df = new SimpleDateFormat("d MMMM yyyy");
        return df.format(tomorrowPlusDays).split(" ");

    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(getTomorrowDateFields()));

        System.out.println(Arrays.toString(addDaysToTomorrow(7)));

    }


}


