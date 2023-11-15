package Models;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.stream.Collectors;

public class Repository implements IRepository {
    private static Repository instance;

    // Private constructor to prevent instantiation
    private Repository() {
    }

    // Static method to get the instance of the class
    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    @Override
    public ArrayList<File> search(Date startDate, Date endDate) {
        File folder = new File(repositoryPath);
        return Arrays.stream(Objects.requireNonNull(folder.listFiles()))
                .filter(f -> f.lastModified() >= startDate.getTime() && f.lastModified() <= endDate.getTime())
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
