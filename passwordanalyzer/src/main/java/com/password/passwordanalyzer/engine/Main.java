package com.password.passwordanalyzer.engine;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String password = null;

        // STEP 1: Check CLI arguments
        if (args.length >= 2 && args[0].equalsIgnoreCase("--password")) {
            password = args[1];
        }

        // STEP 2: If CLI not used, ask via Scanner (old behavior)
        if (password == null || password.isEmpty()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("=== Password Strength Analyzer ===");
            System.out.print("Enter password: ");
            password = scanner.nextLine();
            scanner.close();
        }

        // STEP 3: Process password
        double entropy = EntropyCalculator.calculateEntropy(password);
        String strength = StrengthEvaluator.evaluateStrength(password, entropy);

        // STEP 4: Output result
        System.out.println("\n--- Analysis Result ---");
        System.out.println("Password Strength: " + strength);
        System.out.printf("Entropy: %.2f bits%n", entropy);

        // STEP 5: Suggestions (your original logic)
        if (strength.equals("WEAK")) {
            System.out.println("Suggestions:");
            System.out.println("- Use at least 8 characters");
            System.out.println("- Mix uppercase, lowercase, numbers, and symbols");
            System.out.println("- Avoid common words and sequences");
        } else if (strength.equals("MODERATE")) {
            System.out.println("Suggestions:");
            System.out.println("- Increase password length");
            System.out.println("- Avoid predictable patterns");
        } else {
            System.out.println("Great! Your password is strong.");
        }
    }
}
