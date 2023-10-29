// Hashing Tutorial 7: https://www.desiqna.in/part-7

// Problem:
// Given an unsorted array that may contain duplicates. Also given a number k which is smaller than the size of the array, returns true if the array contains duplicates within k distance.

// Example-1:
// Input: k = 3, arr[] = {1, 2, 3, 4, 1, 2, 3, 4}
// Output: false
// All duplicates are more than k(3) distance away.
// 1...1(has a distance of 4)
// 2...2(has a distance of 4)
// 3...3 and 4...4 are similar 

// Even if we find one duplicate number having a distance less than equal to k(<=k), we would return true.
// Example-2:
// Input: k = 3, arr[] = {1, 2, 3, 1, 4, 5}
// Output: true
// 1 is repeated at distance 3(3<=k hence we return true).

// Brute Force approach: TC: O(N * K), SC: O(1)
// For each element of array, traverse K steps ahead and check for duplicate. If found, return true. If completed entire traversal, return false.

// Optimized approach using HashMap: element -> index: TC: O(N), SC: O(N)
// For each element of array:
// If not contained as Key in HashMap: no duplicate: store element -> index
// If contained as Key in HashMap: duplicate exists before, so check distance: index - Value: if(distance <= K): return true, else store element -> index, as this element will be the closest duplicate for the next one.
// Traversed entire array without returning true, then return false in the end.   

// Code for optimized approach:

import java.util.HashMap;
import java.util.Map;

public class Tut4duplDist {
    public static void main(String[] args) {
        int[] arr = { 10, 5, 3, 4, 3, 5, 6 };
        int K = 3;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];

            if (map.containsKey(num)) {
                int pos = map.get(num);
                int distance = i - pos;
                if (distance <= K) {
                    System.out.println("Duplicate exists withing distance K.");
                    return;
                } else {
                    map.put(num, i);
                }
            } else {
                map.put(num, i);
            }
        }

        System.out.println("No duplicates exist within distance K.");
    }
}
