package com.coursera.algorithm.mergesort;

public class TestMergeSort {

    public static void main(String[] args) {
        //Comparable<Integer>[] array = new Integer[] {1, 20, 6, 4, 5};
        Comparable<Integer>[] array = FileLoader.loadArrayOfIntegersFromFile("IntegerArray.txt");
        
        long begin = System.currentTimeMillis();
        //long inversions = BruteForceSort.sort(array, array.length); // ~ 87 seconds
        long inversions = MergeSort.sort(array, 0, array.length);   // ~ 3,5 seconds
        long end = System.currentTimeMillis();
        
        for (Comparable<?> comparable : array) {
            System.out.println(comparable);
        }
        System.out.println("\nSpent time to sort: " + (end - begin) / 1000.0);
        System.out.println("Number of inversions: " + inversions); // 2407905288
    }
}