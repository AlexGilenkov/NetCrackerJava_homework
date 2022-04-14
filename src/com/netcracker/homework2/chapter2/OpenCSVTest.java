package com.netcracker.homework2.chapter2;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class OpenCSVTest {
    public static void main(String[] args) throws Exception {

        String filePath = "C:/Users/alexx/IdeaProjects/JavaHomework/src/com/netcracker/" +
                "homework2/chapter2/addresses.csv";


        CSVReader reader = new CSVReader(new FileReader(filePath));

        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            if (nextLine != null) {

                System.out.println(Arrays.toString(nextLine));
            }
        }

    }
}
