// Hashing tutorial 6: https://www.desiqna.in/part-6

// Problem: 
// Given an array consisting of positive integers, return the minimum number of operations to make all the elements of the array equal. The operations can be addition, multiplication, division, or subtraction.

// Example:
// Input: arr[] = {1, 4, 4, 3, 3, 4}
// Output: 3
// 4 is most frequent (3 times) i.e. 3 elements are already equal, so it will be easy to apply operations on the other less frequent ones to make them equal to 4.
// 3 operations: 1 (+ 3), 3 (+ 1), 3 (+ 1) 

// Example:
// Input: arr[] = {1, 2, 3, 4}
// Output: 3
// (Since all the elements in the array are unequal, it would require at least 3 operations to make the array equal).

// Main Logic:
// Find most frequent element. 
// Say, it appears K times.
// Now, all the other N - K elements will go through operations to become equal to the most frequent one.
// If none of the element is frequent i.e. all are unequal, consider any one as most frequent one, so K=1. Simply return N-1.

// NOTE: We DON'T ACTUALLY PERFORM THE OPERATIONS, we just return the count of operations required, as that's what's asked.

// Brute-force approach: TC: O(N^2), SC: O(1)
// Find max frequency K such that for frequency of each element traverse the entire array. Return N - K.

// Optimized approach using HashMap: element -> frequency: TC: O(2N), SC: O(N)
// One traversal of entire array for creating frequency map. One traversal of frequency map for getting K. Return N - K.

import java.util.HashMap;
import java.util.Map;

public class Tut3minOps {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 1, 4, 3, 1 };

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];

            int freq = map.getOrDefault(num, 0) + 1;
            map.put(num, freq);
        }

        int maxFreq = 0, K = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                K = entry.getValue();
            }
        }

        System.out.println("Minimum operations: " + (arr.length - K));
        return;
    }
}
