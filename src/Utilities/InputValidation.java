package Utilities;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Pattern;

public class InputValidation {
    public static boolean invalidArgumentCount(String[] arguments) {
        int validArgCount = 2;
        if (arguments.length != validArgCount) {
            System.out.println("Error: Number of arguments passed should be 2. Number of argument passed: " + arguments.length);
            return true;
        }
        return false;
    }

    public static boolean containsCharacters(String date) {
        if (Pattern.matches("[a-zA-Z]+", date)) {
            System.out.println("Error: Value contains characters: " + date);
            return true;
        }
        return false;
    }

    public static boolean invalidDateRange(Date startDate, Date endDate) {
        // Use LocalDate for date-only comparison
        return startDate.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate()
                .isAfter(endDate.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate());
    }


    public static String getFormattedCurrentDateTime() {
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Define the desired date-time format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");

        // Format the current date and time
        return currentDateTime.format(formatter);
    }

    public static boolean checkInvalidDateValues(String startDate, String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");

        try {
            LocalDateTime startDateTime = LocalDateTime.parse(startDate, formatter);
            LocalDateTime endDateTime = LocalDateTime.parse(endDate, formatter);

            // Define valid range
            LocalDateTime validStartDate = LocalDateTime.parse("19700101_000000", formatter); // Jan. 1, 1970 is first date in computing
            LocalDateTime validEndDate = LocalDateTime.parse(getFormattedCurrentDateTime(), formatter); // Today's current date and time

            // Check if dates are within the valid range - NOT WORKING
//            boolean outOfRange = startDateTime.isBefore(validStartDate) || startDateTime.isAfter(validEndDate) ||
//                    endDateTime.isBefore(validStartDate) || endDateTime.isAfter(validEndDate);
//            if (outOfRange) {
//                System.out.println("Error: Date values are out of range." + validEndDate);
//                return true;
//            }

            if (startDateTime.isAfter(endDateTime)) {
                System.out.println("Error: Start date is greater than the end date.");
            }

            return startDateTime.isAfter(endDateTime);

        } catch (Exception e) {
            // Handle parsing exception (invalid date format)
            System.out.println("Error: Invalid date range.");
            System.out.println(e.getMessage());
            return true;
        }
    }

    public static boolean checkInvalidDates(String[] arguments) {
        if (invalidArgumentCount(arguments)) {
            return true;
        }
        String startDate = arguments[0];
        String endDate = arguments[1];
        return containsCharacters(startDate) || containsCharacters(endDate) || checkInvalidDateValues(startDate, endDate);
    }
}
