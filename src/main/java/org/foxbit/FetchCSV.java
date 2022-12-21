package org.foxbit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class FetchCSV {

    private final String filePath;
    private List<String> content = new ArrayList<>();

    /**
     * Creates new {@code FetchCSV} that takes a file path to evaluate a file that is named by the path.
     * @param filePath the path to a {@code .csv} file
     * @throws FileNotFoundException when the file can't be found.
     */
    public FetchCSV(String filePath) throws FileNotFoundException {
        if (filePath.isBlank() || filePath == null)
            throw new FileNotFoundException();
        this.filePath = filePath;
    }

    /**
     * Creates new {@code FetchCSV} that uses the participants.csv in the package.
     * @throws FileNotFoundException when the file can't be found.
     */
    public FetchCSV() throws FileNotFoundException {
        String filePath = "src/main/java/org/foxbit/participants.csv";
        if (filePath.isBlank() || filePath == null)
            throw new FileNotFoundException();
        this.filePath = filePath;
    }

    /**
     * Reads the {@code .csv} file into a {@code list of strings}
     * @throws IOException when something is wrong during the reading process.
     * @see BufferedReader
     * @see FileReader
     * @see List
     */
    public void fetchContent() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(this.filePath))) {
            String line = null;
            String[] values;
            while ((line = bufferedReader.readLine()) != null) {
                values = line.split(",");
                for (int n = 0; n < values.length; n++) {
                    content.add(values[n]);
                }
            }
        } catch (Exception ex) {
            throw new IOException("Error while Reading: " + ex.getMessage());
        }
    }

    /**
     * @param n a number that represents an index
     * @return the value at {@code index n}
     */
    public String getValue(int n) {
        return this.content.get(n);
    }

    /**
     * This method prints the {@code sourceList}.
     * @param sourceList a List of strings
     */
    public void ShowContent(List<String> sourceList) {
        int n = 0;
        for (String value : sourceList) {
            System.out.println(n + 1 + ": " + value);
        }
    }
}
