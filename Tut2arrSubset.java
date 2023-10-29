// Hashing Tutorial 4: https://www.desiqna.in/check-if-the-given-array-is-subset-of-another-array-hashing-part-4

// Problem: Given two arrays, arr1 and arr2, check if arr2 is a subset of arr1. You can assume there are no duplicates in both the arrays.

// Brute Force Approach: Check if each element of arr2 is present in arr1, by traversing arr1 for each arr2 element.
// TC: O(M * N), SC: O(1)

// Optimized Approach using HashSet: Store all arr1 elements in a HashSet. Check if HashSet contains all elements of arr2.
// TC: O(N + M) average case and O(N + M*N) for a worst case that is very rare, SC: O(N)

// Code for optimized approach:

// import java.util.HashSet;
// import java.util.Set;

// public class Tut2arrSubset {
//     public static void main(String[] args) {
//         int[] arr1 = { 6, 7, 3, 2 };
//         int[] arr2 = { 2, 3 };

//         Set<Integer> set = new HashSet<>();

//         for (int num : arr1) {
//             set.add(num);
//         }

//         for (int num : arr2) {
//             if (!set.contains(num)) {
//                 System.out.println("arr2 is not a subset of arr1");
//                 return;
//             }
//         }
//         System.out.println("arr2 is a subset of arr1");
//         return;
//     }
// }

//////////////////////////////////////////////////////////////////////////

// Hashing Tutorial 5: https://www.desiqna.in/part-5

// Problem: Same as above, but this time any or both of the arrays may contain
// duplicate elements.

// Example:
/*
 * Example-1:
 * 
 * Input:
 * 
 * arr1 = {2,4,7,1,5,5}
 * 
 * arr2 = {5,4,2}
 * 
 * Output: arr2 is a subset of arr1
 * 
 * Explanation: All elements of arr2 are present in arr1.
 * 
 * 
 * 
 * Example-2:
 * 
 * Input:
 * 
 * arr1 = {9,3,1,5,2,1}
 * 
 * arr2 = {9,1,1,1}
 * 
 * Output: arr2 is not a subset of arr1
 * 
 * Explanation: Element 1 is present twice in arr1 and thrice in arr2.
 */

// In this problem, we can't use a HashSet as we don't want the duplicate
// elements to be skipped.
// Brute-force approach: Same as before. TC: O(M * N), SC: O(1)
// Optimized approach using HashMap: element -> frequency: O(N + M) average case
// and O(N + M*N) for a worst case that is very rare, SC: O(N)
// For each element of arr2 check if key present in HashMap and its value is not
// 0.
// The moment you get an element of arr2 not present as key in HashMap or its
// value in HashMap is 0, return false.

import java.util.HashMap;
import java.util.Map;

public class Tut2arrSubset {
    public static void main(String[] args) {
        int[] arr1 = { 6, 7, 3, 2, 2 };
        int[] arr2 = { 6, 7, 2, 2 };

        boolean ans = isSubset(arr1, arr2);

        if (ans)
            System.out.println("arr2 is a subset of arr1");
        else
            System.out.println("arr2 is not a subset of arr1");

        return;
    }

    static boolean isSubset(int[] arr1, int[] arr2) {
        // Simple case:
        if (arr2.length > arr1.length) {
            return false;
        }

        Map<Integer, Integer> fmap = new HashMap<>();
        for (int num : arr1) {
            int freq = fmap.getOrDefault(num, 0) + 1;
            fmap.put(num, freq);
        }

        for (int num : arr2) {
            if (!fmap.containsKey(num) || fmap.get(num) == 0) {
                return false;
            } else {
                int freq = fmap.get(num);
                fmap.put(num, freq - 1);
            }
        }
        return true;
    }
}