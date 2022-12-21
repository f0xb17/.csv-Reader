//
//  FetchCSV.java
//  Class to read CSV Files without additional Frameworks.
//
//  Created by f0xb17 on 12/21/2022.
//  Copyright © 2022 f0xb17. All rights reserved.
//

package org.foxbit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public final class FetchCSV {

    private static List<String> content = new ArrayList<>();
    private FetchCSV() {
        // Should not be instantiated: this is a utility class.
    }

    /**
     * This method takes a .csv file and store the values to an ArrayList of strings.
     * @param filePath path/to/file
     */
    public static void fetchContent(String filePath) {
        if (filePath.isBlank() || filePath == null) throw new NullPointerException("Filepath is empty or null!");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while((line = bufferedReader.readLine()) != null) {
                for(int index = 0; index < line.split(",").length; index++) {
                    content.add(line.split(",")[index]);
                }
            }
            bufferedReader.close();
        } catch (Exception ex) {
            System.out.println("Error while reading: " + ex.getMessage());
        }
    }

    /**
     * @param index index of a value inside the ArrayList of strings
     * @return the value at index x
     */
    public static String getValue(int index) {
        return content.get(index);
    }
}
