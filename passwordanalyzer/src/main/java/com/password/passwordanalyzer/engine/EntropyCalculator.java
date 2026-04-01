package com.password.passwordanalyzer.engine;

//This class measures how unpredictable a password is

public class EntropyCalculator {

    public static double calculateEntropy(String password) {
        int charSetSize = 0;

        if (containsLowercase(password)) charSetSize += 26;
        if (containsUppercase(password)) charSetSize += 26;
        if (containsDigit(password)) charSetSize += 10;
        if (containsSpecial(password)) charSetSize += 32;

        int length = password.length();

        if (charSetSize == 0 || length == 0) {
            return 0.0;
        }

        return length * (Math.log(charSetSize) / Math.log(2));
    }

    private static boolean containsLowercase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) return true;
        }
        return false;
    }

    private static boolean containsUppercase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) return true;
        }
        return false;
    }

    private static boolean containsDigit(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) return true;
        }
        return false;
    }

    private static boolean containsSpecial(String password) {
        for (char c : password.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) return true;
        }
        return false;
    }
}
