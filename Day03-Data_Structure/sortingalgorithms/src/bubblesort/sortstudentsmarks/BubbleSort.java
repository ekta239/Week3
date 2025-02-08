package bubblesort.sortstudentsmarks;
public class BubbleSort {
    //create static integer type bubblesort function
    
        public static int[] bubblesort(int[]marks) {
            
            int n=marks.length;
            for (int i=0; i<n-1; i++) {
                for (int j=0; j<n-1; j++ ) {
                    if (marks[j]>marks[j+1]) {
                        //swappin the elements 
                        marks[j]=marks[j]^marks[j+1];
                        marks[j+1]=marks[j]^marks[j+1];
                        marks[j]=marks[j]^marks[j+1];
                    }
                }
        }
        return marks;
        }
        //main method
        public static void main(String[] args) {
        //input the marks array and print marks before sorting
            int[] marks={2,3,0,9,2,0,3};
            System.out.println("\nUnsorted marks: ");
            for (int i=0; i<marks.length; i++) {
                System.out.print(marks[i]+" ");
            }
            System.out.println();
            //call the bubblesort function and print sorted marks
            int[] result=bubblesort(marks);
            System.out.println("Sorted Marks(in ascending order) using bubble sort : ");
            for (int i=0; i<result.length; i++) {
                System.out.print(result[i]+" ");
            }
        }
    }
