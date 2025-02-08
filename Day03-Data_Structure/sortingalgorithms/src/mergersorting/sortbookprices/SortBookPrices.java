package mergersorting.sortbookprices;

import java.lang.reflect.Array;
import java.util.Arrays;
//create  class sortBookPrices
public class SortBookPrices {
    //create mergesort function with the parameters
    public static void mergersort(float[] prices, int left, int right) {
        if (left < right) {
            int mid = left +(right-left)/2;
//function calling itself
            mergersort(prices, left, mid);
            mergersort(prices, mid+1, right);
            merge(prices, left, mid, right);
        }
        }
        //create function merge 
        public static void merge(float[] prices, int left, int mid, int right) {
            int n1= mid- left+1;
            int n2= right-mid;
//create subarrays
            float[] leftSubarr=new float[n1];
            float[] rightSubarr=new float[n2];

            System.arraycopy(prices, left, leftSubarr, 0, n1);
            System.arraycopy(prices, mid+1, rightSubarr, 0, n2);

            //compare the elements 
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftSubarr[i] <= rightSubarr[j]) {
                prices[k++] = leftSubarr[i++];
            } else {
                prices[k++] = rightSubarr[j++];
            }
        }
        while (i < n1) prices[k++] = leftSubarr[i++];
        while (j < n2) prices[k++] = rightSubarr[j++];
    }
//create main method
    public static void main(String[] args) {
        //print unsorted array
        System.out.print("Unsorted Books Prices:\n");
        float[] prices={100.0f,90.0f,50.0f,250.0f,80.0f};
        //print sorted array
        System.out.println(Arrays.toString(prices));
        System.out.print("Sorted Books Price(in ascending order) using merge Sort:\n");
        mergersort(prices, 0, prices.length-1 );
        System.out.println(Arrays.toString(prices));
    }

}