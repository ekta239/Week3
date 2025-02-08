package com.stringbuilder.removeduplicates;

import java.util.HashSet;
//create class name removeDuplicate
public class removeDuplicate {
    //create function with parameters and create object
    public String duplicateString(String str) {
        StringBuilder sb = new StringBuilder();
        //create hashset
        HashSet<Character> duplicate = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!duplicate.contains(ch)) {
                duplicate.add(ch);
                sb.append(ch);
            }
        }
        return sb.toString();
    }
//create main method
    public static void main(String[] args) {
        //create class object and call the function then print both the Strings
        removeDuplicate duplicate = new removeDuplicate();
        String str = "banana";
        System.out.println("original String: "+str);
        System.out.println("String after solution using string builder: "+duplicate.duplicateString(str));
    }
}
