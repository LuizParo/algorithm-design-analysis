package com.coursera.algorithm.mergesort;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileLoader {

    public static Integer[] loadArrayOfIntegersFromFile(String file) {
        Integer[] array = new Integer[100_000];
        
        try(Scanner scanner = new Scanner(getFile(file), "UTF-8")) {
            scanner.useDelimiter("\\n");
            
            int i = 0;
            while(scanner.hasNext()) {
                Integer integer = Integer.valueOf(scanner.next().trim());
                array[i] = integer;
                ++i;
            }
            
            return array;
        } catch (IOException e) {
            throw new RuntimeException("Unable to process file: " + file, e);
        }
    }

    private static File getFile(String file) {
        ClassLoader classLoader = FileLoader.class.getClassLoader();
        return new File(classLoader.getResource(file).getFile());
    }
}