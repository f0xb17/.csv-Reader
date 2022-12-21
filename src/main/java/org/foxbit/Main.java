package org.foxbit;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
       try {

           FetchCSV fetchCSV = new FetchCSV();
           fetchCSV.fetchContent();

           System.out.println(fetchCSV.getValue(1));

       } catch (Exception ex) {
           System.out.println(ex.getMessage());
       }
    }
}