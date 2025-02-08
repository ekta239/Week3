package com.stringbuffer.comparestringbufferwithstringbuilder;
import java.util.Arrays;
import java.io.*;

public class comparison {
    public String stringBuffer(String[] str) {
        StringBuffer sb=new StringBuffer();
        
        for (String i:str){
        sb.append(i+" ");
    }
    return sb.toString();
}

 public String stringBuilder(String[] str) {
    StringBuilder sb=new StringBuilder();
    for (String i:str) {
        sb.append(i+" ");
    }
    return sb.toString();
 }

//create main method
public static void main(String[] args) {
    //create class object and function calling
    comparison compare=new comparison();
    //print string begore and after concate
    String[] str = {"Ekta","Verma."};
    System.out.println("given String's Array: "+Arrays.toString(str));
    System.out.println();
      // Measure time for StringBuffer
      long startTimeBuffer = System.nanoTime();
      String resultBuffer = compare.stringBuffer(str);
      long endTimeBuffer = System.nanoTime();
      long durationBuffer = endTimeBuffer - startTimeBuffer;
      System.out.println("Concatenation using StringBuffer: " + resultBuffer);
      System.out.println("Time taken using StringBuffer: " + durationBuffer + " nanoseconds");
      System.out.println();

      // Measure time for StringBuilder
      long startTimeBuilder = System.nanoTime();
      String resultBuilder = compare.stringBuilder(str);
      long endTimeBuilder = System.nanoTime();
      long durationBuilder = endTimeBuilder - startTimeBuilder;
      System.out.println("Concatenation using StringBuilder: " + resultBuilder);
      System.out.println("Time taken using StringBuilder: " + durationBuilder + " nanoseconds");
    }
}

