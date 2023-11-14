import Views.ActivityMain;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File; import java.text.SimpleDateFormat; import java.util.ArrayList;
import java.util.Date;import java.text.DateFormat;
public class App {
    public static void main(String[] args) throws Exception {
        ActivityMain activity = new ActivityMain();
        activity.onCreate();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        activity.onInput(input);
    }
}