package com.password.passwordanalyzer.engine;

import java.util.Arrays;
import java.util.List;

//this module detects predictable human patterns like common words, sequences, and repeated characters that reduce real password security


public class PatternChecker {

    private static final List<String> COMMON_PASSWORDS = Arrays.asList(
            "password", "admin", "welcome", "qwerty", "letmein"
    );

    public static boolean hasCommonWord(String password) {
        String lower = password.toLowerCase();
        for (String word : COMMON_PASSWORDS) {
            if (lower.contains(word)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasSequentialChars(String password) {
        String lower = password.toLowerCase();

        for (int i = 0; i < lower.length() - 2; i++) {
            char c1 = lower.charAt(i);
            char c2 = lower.charAt(i + 1);
            char c3 = lower.charAt(i + 2);

            if (c2 == c1 + 1 && c3 == c2 + 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasRepeatedChars(String password) {
        for (int i = 0; i < password.length() - 2; i++) {
            char c1 = password.charAt(i);
            char c2 = password.charAt(i + 1);
            char c3 = password.charAt(i + 2);

            if (c1 == c2 && c2 == c3) {
                return true;
            }
        }
        return false;
    }
}
