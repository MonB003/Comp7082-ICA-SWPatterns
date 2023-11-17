package Presenters;

import Models.Repository;
import Utilities.InputValidation;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Stream;

public class Presenter {
    public interface IView {
        void displayResult(String result);
    }
     private final IView view;
     private final Repository repository;

    public Presenter(IView view) {
        this.view = view;
        this.repository = Repository.getInstance();
    }

    public void getFileResult(String input) throws Exception {
        // Receiving input from the user
        String[] dates = input.split(",");

        // Validate input
        if (InputValidation.checkInvalidDates(dates)) {
            return;
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date startDate = format.parse(dates[0]);
        Date endDate = format.parse(dates[1]);

        // Call Repository instance to search for the files that match the specified criteria
        ArrayList<File> files = repository.search(startDate, endDate);
        StringBuilder result = new StringBuilder();
        // Use stream for filtering file results
        Stream<File> fileStream = files.stream();
        fileStream.forEach(file ->  result.append(file.getPath()).append(" "));
        view.displayResult(result.toString());
    }
}
