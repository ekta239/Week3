package selectionsort.sortexamscores;

import java.util.Arrays;
//create class SortExamScores
public class SortExamScores {
    //create static function SelectionSort with parameters  
    public static void SelectionSort(int[] scores) {
        for (int i=0; i<scores.length-1; i++) {

            int minIdx=i;
           //comparing elements
            for (int j=i+1; j<scores.length; j++) {
                if (scores[j] < scores[minIdx]) {
                    minIdx=j;
                }
            }
            //swap the elements
            int temp = scores[i];
            scores[i] = scores[minIdx];
            scores[minIdx] = temp;

        }
    }
    //main method
    public static void main(String[] args) {
        //input array and print unsorted array
        System.out.println("Unsorted Exam Scores: ");
        int[] scores={2,3,0,9,2,5,1,5};
        System.out.println(Arrays.toString(scores));
        //function calling and print sorted array
        System.out.println("Sorted Exam Scores(in ascending order) using selection sorting: ");
        SelectionSort(scores);
    
            System.out.print(Arrays.toString(scores));
        }
    }
    