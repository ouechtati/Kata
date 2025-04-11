package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Scanner;

@Component
public class BatchProcessor {

    @Autowired
    private TransformService transformService;

    public void processFile(String inputPath, String outputPath) {
        try (Scanner scanner = new Scanner(new File(inputPath));
             PrintWriter writer = new PrintWriter(new FileWriter(outputPath))) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                try {
                    int number = Integer.parseInt(line);
                    String result = transformService.transform(number);
                    writer.println(number + " \"" + result + "\"");
                } catch (NumberFormatException e) {
                    writer.println("Invalid input: " + line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
