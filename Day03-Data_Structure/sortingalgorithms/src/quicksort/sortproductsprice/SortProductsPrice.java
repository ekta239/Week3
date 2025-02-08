package quicksort.sortproductsprice;

import java.util.Arrays;
//create class SortProductsPrices
public class SortProductsPrice {
    //create QuickSort functions
    public static void QuickSort(int[] prices, int low, int high) {
        if (low < high) {
            int pivot=partition(prices, low, high);
            QuickSort(prices, low, pivot-1);
            QuickSort(prices, pivot+1, high);
        }
    }
    //create function partition and swapping elements
    public static int partition(int[] prices, int low, int high) {
        int pivot=prices[high];
        int i=low-1;
        for (int j=low; j<high; j++) {
            if (prices[j]<pivot) {
                i++;
                prices[i]=prices[i]^prices[j];
                prices[j]=prices[i]^prices[j];
                prices[i]=prices[i]^prices[j];
            }
         }
        
        prices[i+1]=prices[i+1]^prices[high];
        prices[high]=prices[i+1]^prices[high];
        prices[i+1]=prices[i+1]^prices[high];
        return i+1;
    }

//main method
    public static void main(String[] args) {
        //given input and print unsorted array
        int[] prices={2,10,12,9,5,0};
        System.out.println("Unsorted Products price:");
        
        System.out.println(Arrays.toString(prices));

//function calling and print sorted array using quick sort
        QuickSort(prices, 0, prices.length-1);
        System.out.println("Sorted products price list(in ascending order) using quick sort");
        
        System.out.println(Arrays.toString(prices));

    }
}
