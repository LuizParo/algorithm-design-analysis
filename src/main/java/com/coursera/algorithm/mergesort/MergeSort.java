package com.coursera.algorithm.mergesort;

public class MergeSort {

    public static long sort(Comparable<?>[] array, int begin, int end) {
        long inversions = 0;
        int quantity = end - begin;
        
        if(quantity > 1) {
            int middle = (begin + end) >>> 1;
            inversions = sort(array, begin, middle);
            inversions += sort(array, middle, end);
            
            inversions += merge(array, begin, middle, end);
        }
        return inversions;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private static long merge(Comparable<?>[] array, int begin, int middle, int end) {
        Comparable<?>[] result = new Comparable<?>[array.length];
        long inversions = 0;
        int actual = 0;
        int beginToMiddle = begin;
        int middleToEnd = middle;
        
        while(beginToMiddle < middle && middleToEnd < end) {
            Comparable elementOne = array[beginToMiddle];
            Comparable elementTwo = array[middleToEnd];
            
            if(elementOne.compareTo(elementTwo) < 0) {
                result[actual] = elementOne;
                ++beginToMiddle;
            } else {
                inversions += (middle - beginToMiddle);
                result[actual] = elementTwo;
                ++middleToEnd;
            }
            ++actual;
        }
        
        while(beginToMiddle < middle) {
            result[actual] = array[beginToMiddle];
            ++beginToMiddle;
            ++actual;
        }
        
        while(middleToEnd < end) {
            result[actual] = array[middleToEnd];
            ++middleToEnd;
            ++actual;
        }
        
        System.arraycopy(result, 0, array, begin, actual);
        return inversions;
    }
}