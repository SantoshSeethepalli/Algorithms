package com.DSA.TUF.Hashing.module_1;

import java.util.*;

public class CharacterHashing {

    char[] arr;
    int[] hashArray;

    public CharacterHashing(char[] arr) {

        this.arr = arr;
        hashArray = new int[26];
        computeHashArray();
    }

    private void computeHashArray() {

        for(char c : arr) {

            hashArray[c - 'a']++;
        }
    }

    public int getFrequency(char c) {

        int queryIdx = c - 'a';
        if(queryIdx < 0 || queryIdx >= 26) return 0;

        return hashArray[queryIdx];
    }

    public static void main(String[] args) throws InputMismatchException{

        Scanner scan = new Scanner(System.in);

        // load initial data
        int size = scan.nextInt();

        char[] arr = new char[size];
        for(int idx = 0; idx < size; idx++) arr[idx] = scan.next().charAt(0);

        // load queries
        int totalNumberOfQueries = scan.nextInt();

        List<Character> queries = new ArrayList<>();
        for(int idx = 0; idx < totalNumberOfQueries; idx++) queries.add(scan.next().charAt(0));

        // Print the frequency for each query using the getFrequency() method
        CharacterHashing characterHashing = new CharacterHashing(arr);

        for(char q : queries) {

            System.out.println(
                    characterHashing.getFrequency(q)
            );
        }
    }
}
