package stacksqueues.circulartourproblem;

import java.util.LinkedList;
import java.util.Queue;

public class circularTour {
    static class PetrolPump {
        int petrol;
        int distance;
        
        PetrolPump(int p, int d) {
            this.petrol = p;
            this.distance = d;
        }
    }

        public static int findStartingPoint(int[] petrol, int[] distance) {
        int n = petrol.length;
        Queue<Integer> queue = new LinkedList<>();
        
        int start = 0, currPetrol = 0, deficit = 0;
        
        for (int i = 0; i < n; i++) {
            currPetrol += petrol[i] - distance[i];
            queue.add(i);
            
            // If we run out of petrol, reset the starting point
            if (currPetrol < 0) {
                deficit += currPetrol;
                currPetrol = 0;
                start = i + 1;
                queue.clear();  // Reset queue since we failed
            }
        }
        
        return (currPetrol + deficit >= 0) ? start : -1;  // If total fuel covers total distance, return start
    }

//         float a=0, d=0;
//         for (int i=0; i<petrol.length; i++) {
//         int j=i;
        
//         if (petrol[i]<distance[i]) {
//             d+=distance[i]-petrol[i];
//         }
//         while (distance[j]<=petrol[j]&&j<petrol.length-1) {
//             a=petrol[j] - distance[j];
//             j++; }
//         if (d<a) {
//             return i;
                
//         }
        
        
//         }
//         return -1;
//     }
// }
}