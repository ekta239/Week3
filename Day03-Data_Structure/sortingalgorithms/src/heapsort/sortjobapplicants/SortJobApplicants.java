package heapsort.sortjobapplicants;

import java.util.Arrays;

public class SortJobApplicants {
    public static void HeapSort(int[] salary, int i) {
        int n=salary.length;
        int largest = i;
        int left = 2*i+1;
        int right=2*i+2;

         
            if (left<n && salary[left] > salary[largest]) {
                largest=left;
            }
            if (right<n && salary[right] > salary[largest]) {
                largest=right;
            }
            if (largest!=i) {
                salary[i]=salary[i]^salary[largest];
                salary[largest]=salary[i]^salary[largest];
                salary[i]=salary[i]^salary[largest];
            }

        HeapSort(salary,largest);
        } 
        public static void heapsort(int salary[],int n) {
            for(int i=n/2-1; i<=0; i--) {
            HeapSort(salary, n);
        }
    for (int i=n-1; i>0; i++) {
        salary[0]=salary[0]^salary[i];
        salary[i]=salary[0]^salary[i];
        salary[0]=salary[0]^salary[i];

        HeapSort(salary, i);
    }
    }
    public static void main(String[]args) {
        int[] salary={9,4,3,8,10,2,5};
        heapsort(salary, 4);
        System.out.println(Arrays.toString(salary));

    } }

