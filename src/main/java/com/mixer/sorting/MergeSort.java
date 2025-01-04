package com.mixer.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] a = {10,9,8,7,6,5,4,3,2,1};
        sort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }

    static void merge(int arr[], int startIndex, int middleIndex, int endIndex) {
        // Find sizes of two subarrays to be merged
        int sizeOfFirstSubArray = middleIndex - startIndex + 1;
        int sizeOfSecondSubArray = endIndex - middleIndex;

        // Create temp arrays
        int tempFirstSubArray[] = new int[sizeOfFirstSubArray];
        int tempSecondSubArray[] = new int[sizeOfSecondSubArray];

        // Copy data to temp arrays
        for (int i = 0; i < sizeOfFirstSubArray; ++i)
            tempFirstSubArray[i] = arr[startIndex + i];
        for (int j = 0; j < sizeOfSecondSubArray; ++j)
            tempSecondSubArray[j] = arr[middleIndex + 1 + j];

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = startIndex;
        while (i < sizeOfFirstSubArray && j < sizeOfSecondSubArray) {
            if (tempFirstSubArray[i] <= tempSecondSubArray[j]) {
                arr[k] = tempFirstSubArray[i];
                i++;
            }
            else {
                arr[k] = tempSecondSubArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of tempFirstSubArray[] if any
        while (i < sizeOfFirstSubArray) {
            arr[k] = tempFirstSubArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of tempSecondSubArray[] if any
        while (j < sizeOfSecondSubArray) {
            arr[k] = tempSecondSubArray[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[startIndex..endIndex] using
    // merge()
    static void sort(int arr[], int startIndex, int endIndex)
    {
        if (startIndex < endIndex) {

            // Find the middle point
            int m = startIndex + (endIndex - startIndex) / 2;

            // Sort first and second halves
            sort(arr, startIndex, m);
            sort(arr, m + 1, endIndex);

            // Merge the sorted halves
            merge(arr, startIndex, m, endIndex);
        }
    }

    /*public static void mergeSort(int[] a, int s, int e) {
        if(s < e) {
            int mid = (s+(e-s))/2;
            mergeSort(a, s, mid);
            mergeSort(a,mid+1, e);
            merge(a, s, mid, e);
        }
    }

    private static void merge(int[] a, int s, int mid, int e) {
        int lSize = mid-s+1;
        int rSize = e-(mid+1)+1;

        int leftArray[]  = new int[lSize];
        int rightArray[] = new int[rSize];

        //fill data in temporary arrays
        for(int i=0; i<lSize; i++) {
            leftArray[i] = a[s+i];
        }
        for(int j=0; j<rSize; j++) {
            rightArray[j] = a[mid+1+j];
        }

        int i=0,j=0,k=s;

        while(i<lSize && j<rSize) {
            if(leftArray[i]<=rightArray[j]) {
                a[k] = leftArray[i];
                i++;
            } else {
                a[k] = rightArray[j];
                j++;
            }
            k++;
        }

        //left over elements in leftArray
        while(i<lSize) {
            a[k] = leftArray[i];
            k++; i++;
        }

        //left over elements in rightArray
        while(j<rSize) {
            a[k] = rightArray[j];
            k++; j++;
        }
    }*/
}
