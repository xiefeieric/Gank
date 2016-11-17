package uk.me.feixie.gank.Utils;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by Fei on 17/11/2016.
 */

public class DateUtils {

    public static String formatDate(String pattern, DateTime dateTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern, Locale.getDefault());
        return dateFormat.format(dateTime.toDate());
    }

}
