package org.foxbit;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            FetchCSV.fetchContent("src/main/java/org/foxbit/test.csv");
            System.out.println(FetchCSV.getValue(1));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}