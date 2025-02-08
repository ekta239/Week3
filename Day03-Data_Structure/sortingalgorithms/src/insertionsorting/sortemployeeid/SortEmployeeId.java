package insertionsorting.sortemployeeid;
//create class 
public class SortEmployeeId {
    //create InsertionSort function 
    public static int[] InsertionSort(int[] EmployeeId) {
        for (int i=0; i<EmployeeId.length; i++) {
            int key = EmployeeId[i];
            int j = i-1;
            //while loop to check element if it is greater then key or not
            while (j>=0 && EmployeeId[j] > key) {
                EmployeeId[j+1]=EmployeeId[j];
                j--;
            }
            EmployeeId[j+1] =key;
        }
        return EmployeeId;
    }
    //create main method
    public static void main(String[] args) {
        //input Employee Id Array
        int[] EmployeeId={9,15,4,96,5,74};
        System.out.print("Unsorted Employee ID: ");
        for (int i:EmployeeId) {
            System.out.print(i+" ");
        }
        System.out.println();
        //function calling and print sorted array
        int[] result=InsertionSort(EmployeeId);
        System.out.print("Sorted Employee Id (in ascending order) using insertion sorting: ");
        for (int i:result) {
            System.out.print(i+" ");
        }
    }
}
