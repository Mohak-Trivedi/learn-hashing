// Hashing Tutorial 1: https://www.desiqna.in/hashing+find+frequency+of+each+number+in+the+array

// Problem: Given an array of n positive integers in range [0, n-1]. Q queries
// are given each having a positive integer, return their frequencies.

// Brute-force:
// TC: O(n^2), SC: O(1)
// public class Tut1freq {
// public static void main(String[] args) {
// int[] arr = { 1, 3, 3, 4, 1, 4, 4, 4, 4 };
// int[] queries = { 3, 4, 1 };

// for (int i = 0; i < queries.length; i++) {
// int q = queries[i];
// int freq = 0;

// for (int j = 0; j < arr.length; i++) {
// int num = arr[j];
// if (num == q) {
// freq++;
// }
// }

// System.out.println(freq);
// }

// return;
// }
// }

// Optimized approach : Hash Table (pre-computed array):
// b[num] -> freq of element num of arr.
// TC: O(N + Q), SC: O(n)
// public class Tut1freq {
//     public static void main(String[] args) {
//         int[] arr = { 1, 3, 3, 4, 1, 4, 4, 4, 4 };
//         int[] queries = { 3, 4, 1 };

//         int[] b = new int[4];
//         for (int i = 0; i < b.length; i++) {
//             b[i] = 0;
//         }

//         for (int i = 0; i < arr.length; i++) {
//             int num = arr[i];
//             b[num] += 1;
//         }

//         for (int i = 0; i < queries.length; i++) {
//             int q = queries[i];
//             System.out.println(b[q]);
//         }

//         return;
//     }
// }

/////////////////////////////////////////////////////////////////////
// Hashing Tutorial 2: https://www.desiqna.in/hashset-and-hashmap-hashing-part-2

// Revise Set:
// https://github.com/Mohak-Trivedi/learn-java-collections/blob/main/LearnSet.java

// Revise Map:
// https://github.com/Mohak-Trivedi/learn-java-collections/blob/main/LearnMap.java

/*
 * Remember:
 * HashMap: O(1) Average Case for Insertion, Find, Deletion. O(n) Worst case
 * (but very rare - why? learn later)
 * 
 * TreeMap: O(logn) Worst Case for Insertion, Find, Deletion
 * 
 * Similarly, for HashSet and TreeSet.
 */

/////////////////////////////////////////////////////////////////////
// Hashing Tutorial 3: https://www.desiqna.in/part-3

// Problem: Same as 1, but now the elements in array are not in [0, n-1],
// instead [0, 1000000000).

// Brute force: TC: O(N * Q), SC: O(1)
// Optimized: Hash Table (Precomputed array): TC: O(N + Q), SC: O(1000000000)
// even for average and best, apart from worst cases.
// Most Optimized: Hash Set: TC: O(N + Q), SC: O(N) only for average as well as worst case.

// Code for Most Optimized:

import java.util.HashMap;

public class Tut1freq {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 3, 4, 1, 4, 4, 4, 4 };
        int[] queries = { 3, 4, 1 };

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];

            int freq = map.getOrDefault(num, 0) + 1;
            map.put(num, freq);
        }

        for (int i = 0; i < queries.length; i++) {
            int q = queries[i];

            System.out.println(map.getOrDefault(q, 0));
        }

        return;
    }
}
/////////////////////////////////////////////////////////////////////
