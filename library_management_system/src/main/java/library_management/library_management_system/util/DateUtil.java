package library_management.library_management_system.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    public static String formatDate(LocalDate date){
        return date.format(DateTimeFormatter.ofPattern("dd-mm-yyyy"));
    }
}
