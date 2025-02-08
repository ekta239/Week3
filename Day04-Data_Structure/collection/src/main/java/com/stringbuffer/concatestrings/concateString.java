package com.stringbuffer.concatestrings;

import java.util.Arrays;

//create class
public class concateString {
    //create function and function object
    public String concatinate(String[] str) {
        StringBuffer sb=new StringBuffer();
        
        for (String i:str){
        sb.append(i+" ");
    }
    return sb.toString();
}
//create main method
public static void main(String[] args) {
    //create class object and function calling
    concateString concate=new concateString();
    //print string begore and after concate
    String[] str = {"My","name","is", "Ekta","Verma."};
    System.out.println("given String's Array: "+Arrays.toString(str));
    System.out.println("String after concatination using stringBuffer: "+concate.concatinate(str));

}
}
