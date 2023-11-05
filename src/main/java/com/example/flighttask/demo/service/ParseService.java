package com.example.flighttask.demo.service;

import org.springframework.stereotype.Service;

@Service
public class ParseService {

  // Constant to test against
  private final String stringToMatch = "flight";

  // Method to parse and find matches
  public Integer parseString(String inString) {

    // Initialise with max possible integer
    int minFrequency = Integer.MAX_VALUE;
    // Assuming only lowercase alphabets are considered
    int[] charCount = new int[26];

    // Loops throgh each character checks if character is lowercase
    for (char c : inString.toCharArray()) {
      if (c >= 'a' && c <= 'z') {
        // Calculates difference in the characters unicode values to map array index
        charCount[c - 'a']++;
      }
    }

    for (char c : stringToMatch.toCharArray()) {
      int index = c - 'a';
      // Check if character exists in input
      if (charCount[index] == 0) {
        return 0; // If any required character is missing, no match can be formed
      }
      // Whatever the lowest min frequency recorded was, will be how often the
      // complete word could be matched
      minFrequency = Math.min(minFrequency, charCount[index]);
    }

    return minFrequency;
  }
}
