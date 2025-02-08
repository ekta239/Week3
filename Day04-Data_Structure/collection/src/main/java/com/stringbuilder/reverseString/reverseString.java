package com.stringbuilder.reverseString;
//create class reverseString
public class reverseString {
    //create function
    public String StringBuilder (String str) {
        //create an object of function
        StringBuilder sb = new StringBuilder();
        //use .append and .reverse methods
        sb.append(str);
        sb.reverse();
        return sb.toString();
    }
    //main method
    public static void main(String[] args) {
        String str = "hello";
        System.out.println("Original String: "+str);
        //create class object, function calling and print reverse String
        reverseString sb = new reverseString();
        System.out.print("String after reverse using String builder: ");
        System.out.println(sb.StringBuilder(str));
         
    }
}
