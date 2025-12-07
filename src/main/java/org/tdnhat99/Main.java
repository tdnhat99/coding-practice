package org.tdnhat99;

import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isAnagramBruteForce("anagram", "nagaram")); // true
        System.out.println(validAnagram.isAnagramBruteForce("rat", "car")); // false
        System.out.println(validAnagram.isAnagramBruteForce("", "")); // true
    }
}