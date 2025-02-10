package com.linearsearch.wordinlistofsentance;

public class SearchForWord {

    // Function to find the first sentence containing the specific word
    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;  // Return the first sentence containing the word
            }
        }
        return "Not Found";  // Return "Not Found" if no sentence contains the word
    }

    public static void main(String[] args) {
        // Test the function with an array of sentences
        String[] sentences = {
            "The quick brown fox jumps over the lazy dog.",
            "I love programming in Java.",
            "This is a sample sentence."
        };
        String word = "Java";
        System.out.println("Sentence containing the word: " + findSentenceWithWord(sentences, word));
    }
}

