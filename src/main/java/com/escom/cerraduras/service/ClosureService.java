package com.escom.cerraduras.service;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ClosureService {

    /**
     * Generates all binary strings up to a maximum length n
     *
     * @param n Maximum length of binary strings
     * @return Set of all binary strings with length <= n
     */
    public Set<String> generateBinaryStrings(int n) {
        Set<String> result = new HashSet<>();

        // Add empty string for Kleene closure
        result.add("");

        // Generate all binary strings from length 1 to n
        for (int length = 1; length <= n; length++) {
            generateBinaryStringsOfLength(length, "", result);
        }

        return result;
    }

    /**
     * Helper method to recursively generate binary strings of a specific length
     */
    private void generateBinaryStringsOfLength(int length, String current, Set<String> result) {
        if (current.length() == length) {
            result.add(current);
            return;
        }

        generateBinaryStringsOfLength(length, current + "0", result);
        generateBinaryStringsOfLength(length, current + "1", result);
    }

    /**
     * Calculates the Kleene closure (star closure) of binary strings up to length n
     * The Kleene closure includes the empty string and all strings that can be formed
     * by concatenating any number of strings from the set.
     *
     * @param n Maximum length of binary strings
     * @return Set of strings in the Kleene closure
     */
    public Set<String> calculateKleeneClosure(int n) {
        // For binary strings of max length n, the Kleene closure is the set of all
        // possible binary strings of length <= n, plus the empty string
        return generateBinaryStrings(n);
    }

    /**
     * Calculates the positive closure of binary strings up to length n
     * The positive closure includes all strings that can be formed by
     * concatenating one or more strings from the set (no empty string).
     *
     * @param n Maximum length of binary strings
     * @return Set of strings in the positive closure
     */
    public Set<String> calculatePositiveClosure(int n) {
        Set<String> closure = generateBinaryStrings(n);

        // Positive closure doesn't include the empty string
        closure.remove("");

        return closure;
    }
}