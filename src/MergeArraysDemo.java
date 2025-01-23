/******************************************************************************

Given two sorted arrays, the task is to merge them in a sorted manner.

Input: arr1[] = { 1, 3, 4, 5}, arr2[] = {2, 4, 6, 8} 
Output: arr3[] = {1, 2, 3, 4, 4, 5, 6, 8}

Input: arr1[] = { 5, 8, 9}, arr2[] = {4, 7, 8} 
Output: arr3[] = {4, 5, 7, 8, 8, 9} 

*******************************************************************************/
import java.util.*;

public class MergeArraysDemo{
    
    public static void main(String[] args) {
        int arr1[] = {1,1 , 3, 5, 7};

        int arr2[] = {2, 4, 6, 8};

 
        int arr3[] = mergeArrays(arr1, arr2);

        System.out.println("Array after merging - " + Arrays.toString(arr3));
    }
       
    public static int[] mergeArrays(int[] arr1, int[] arr2) {
       // O(n)
    int arr1Length=arr1.length;
    int arr2Length=arr2.length;
       int arr3[] = new int[arr1.length+arr2.length];
       int i=0, j=0, k=0;
      //  System.arraycopy(arr1,0, arr3, arr1.length);
      //  System.arraycopy(arr2,0, arr3, arr1.length,arr2.length);
      
        while(i < arr1Length && j< arr2Length)
        {
            System.out.println("i "+i);
            System.out.println("j "+j);
            if(arr1[i]<=arr2[j]){
                arr3[k++]=arr1[i++];
            }
            else{
                arr3[k++]=arr2[j++];
            }
        }
       // i=9 arr=11
        while(i<arr1Length)
        {
             System.out.println("i1 "+i);
            System.out.println("j1 "+j);
            arr3[k++]=arr1[i++];
        }
        while(j<arr2Length)
        {
             System.out.println("i2 "+i);
            System.out.println("j2 "+j);
            arr3[k++]=arr2[j++];
        }
        return arr3;
    }
    
}
