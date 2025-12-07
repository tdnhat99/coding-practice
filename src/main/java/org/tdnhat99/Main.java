package org.tdnhat99;

public class Main {

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isAnagramBruteForce("anagram", "nagaram")); // true
        System.out.println(validAnagram.isAnagramBruteForce("rat", "car")); // false
        System.out.println(validAnagram.isAnagramBruteForce("", "")); // true
    }
}