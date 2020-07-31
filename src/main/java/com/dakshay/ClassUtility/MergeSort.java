package com.dakshay.ClassUtility;

/**
 * Created by Dakshay on 11/16/2018.
 */
public class MergeSort {
    public static void mergeSort(int ar[],int low, int high){

        if(low<high){
            int mid = low+(high-1)/2;
            mergeSort(ar,low,mid);
            mergeSort(ar,mid+1,high);
        }
    }

    public static void main(String[] args) {
        int ar[] = {4,8,9,6,4,7,5,2,1,3,5,8,3,4};
        int low = 0;
        int high = ar.length;
        mergeSort(ar,low,high-1);
    }
}