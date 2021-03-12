package dam.invisere.gtidic.udl.cat.myevents.models;

import java.util.Date;

public class DateUtils {
    static final long ONE_HOUR = 60 * 60 * 1000L;

    public static int getDuration(Date d1, Date d2){
        return (int) ((d1.getTime() - d2.getTime() + ONE_HOUR) / (24 * ONE_HOUR));
    }

}
