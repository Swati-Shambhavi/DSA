import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
package Heap;
import java.util.*;

class Pair implements Comparable<Pair>{
    int gap;
    int value;
    public Pair(int gap, int value){
        this.gap=gap;
        this.value= value;
    }

    @Override
    public int compareTo(Pair o) {
        if(this.value==o.value){
            return 0;
        }
        else{
            return this.gap-o.gap;
        }
    }
}


public class KClosestNumber {
    public static void main(String[] args) {
        int[] arr= {5,6,7,8,9};
        int k=3;
        int n=7;
        PriorityQueue<Pair> maxHeap= new  PriorityQueue<Pair>(3, Collections.reverseOrder());

        for(int i:arr){
            if(maxHeap.size()<k){
                maxHeap.add(new Pair(Math.abs(i-n),i));
            }
            else{
                if((Math.abs(i-n))< maxHeap.peek().gap){
                    maxHeap.remove();
                    maxHeap.add(new Pair(Math.abs(i-n),i));
                }
            }

        }

        System.out.println("K closest numbers are");
        while(!maxHeap.isEmpty()){
            System.out.println(maxHeap.remove().value);
        }
    }
} */

public class KclosestElements {
    public static void main(String[] args) {
        /*
         * Input: arr = [1,2,3,4,5], k = 4, x = 3 Output: [1,2,3,4]
         */
        int[] arr = { 1, 2, 3, 4, 5 };
        int k = 4, x = 3;
        System.out.println(findClosestElements(arr, k, x));
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int temp = (int) (Math.abs((x - arr[i])));
            pq.add(new int[] { temp, arr[i] });
            if (pq.size() > k) {
                pq.poll();
            }
        }
        while (!pq.isEmpty()) {
            ans.add(pq.poll()[1]);
        }

        return ans;
    }
}
