package Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InputValidation {
    public static boolean invalidDateRange(String startDate, String endDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd_HHmmss");
        format.setLenient(true);

        try {
            Date startDateParsed = format.parse(startDate);
            Date endDateParsed = format.parse(endDate);

            // Define the valid range
            Date validStartDate = format.parse("20230101_000000");
            Date validEndDate = format.parse("20231130_235959");

            // Check if the dates are within the valid range
            return !startDateParsed.before(validStartDate) && !endDateParsed.after(validEndDate);

        } catch (Exception e) {
            // Handle parsing exception (invalid date format)
            System.out.println("Error: Invalid date range.");
            System.out.println(e.getMessage());
            return false;
        }
    }
}
