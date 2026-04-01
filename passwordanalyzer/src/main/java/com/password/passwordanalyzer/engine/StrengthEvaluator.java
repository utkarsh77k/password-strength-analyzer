package com.password.passwordanalyzer.engine;

//This class collects results from all previous steps and gives the final verdict. one of the main part for project.

public class StrengthEvaluator {

    public static String evaluateStrength(String password, double entropy) {

        boolean lengthOK = PasswordRules.hasMinimumLength(password);
        boolean upper = PasswordRules.hasUppercase(password);
        boolean lower = PasswordRules.hasLowercase(password);
        boolean digit = PasswordRules.hasDigit(password);
        boolean special = PasswordRules.hasSpecialCharacter(password);

        boolean hasCommon = PatternChecker.hasCommonWord(password);
        boolean hasSequence = PatternChecker.hasSequentialChars(password);
        boolean hasRepeat = PatternChecker.hasRepeatedChars(password);

        int ruleScore = 0;
        if (upper) ruleScore++;
        if (lower) ruleScore++;
        if (digit) ruleScore++;
        if (special) ruleScore++;

        // Decision logic
        if (!lengthOK || entropy < 30) {
            return "WEAK";
        }

        if (hasCommon || hasSequence || hasRepeat) {
            return "MODERATE";
        }

        if (ruleScore >= 3 && entropy >= 50) {
            return "STRONG";
        }

        return "MODERATE";
    }
}
