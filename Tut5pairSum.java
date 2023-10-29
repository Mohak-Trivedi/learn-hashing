// Hashing Tutorial 8: https://www.desiqna.in/part-8

// Problem:
// Given an array arr1 and number'x',To find if a pair exists in arr1 which can be added to make number'x'.

// Brute Force approach: TC: O(N^2), SC: O(1)
// For each element of array traverse entire array to search for x-element.
// If found, return true, else false.

// Optimized approach using HashSet: TC: O(N)

import java.util.HashSet;
import java.util.Set;

public class Tut5pairSum {
    public static void main(String[] args) {
        int arr[] = { 1, -2, -1, 1, 3 };
        int x = -2;

        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(x - num)) {
                System.out.println("Sum pair exists.");
                return;
            } else {
                set.add(num);
            }
        }
        System.out.println("Sum pair does not exist.");
        return;
    }
}
