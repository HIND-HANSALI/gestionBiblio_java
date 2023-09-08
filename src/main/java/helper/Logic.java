package helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logic {
    // Define a date format that matches the format of the input string
    private static final String DATE_FORMAT = "yyyy-MM-dd"; // Adjust this format as needed

    public static Date stringToDate(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

        try {
            // Parse the input string into a Date object
            Date date = dateFormat.parse(dateStr);
            return date;
        } catch (ParseException e) {
            // Handle parsing errors here (e.g., invalid date format)
            e.printStackTrace();
            return null; // Return null to indicate a parsing error
        }
    }

    // You can add other methods and logic to this class as needed
}
