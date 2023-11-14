package Presenters;

import java.io.File;
import java.util.ArrayList;

public class Presenter {
    public String getFileResult(ArrayList<File> files) {
        String result = "";
        if (files != null) {
            for (File f : files) {
                result += f.getPath() + " ";
            }
        }
        return result;
    }
}
