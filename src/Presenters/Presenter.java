package Presenters;

import Models.Repository;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class Presenter {
    public String getFileResult(Date startDate, Date endDate) {
        //  Call Repository instance to search for the files that match the specified criteria
        Repository repository = Repository.getInstance();
        ArrayList<File> files = repository.search(startDate, endDate);

        StringBuilder result = new StringBuilder();
        if (files != null) {
            for (File f : files) {
                result.append(f.getPath()).append(" ");
            }
        }
        return result.toString();
    }
}
