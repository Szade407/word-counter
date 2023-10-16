package com.example.wordcount;

public class CountUtility {
    public static int countWords(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        String[] words = input.split("[\\s,\\.]");
        return words.length;
    }

    public static int countCharacters(String input) {
        return input.length();
    }
}
